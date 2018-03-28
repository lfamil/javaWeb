package com.neusoft.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.consts.Const;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.entity.vo.OrderItemVO;
import com.neusoft.entity.vo.ProductVO;
import com.neusoft.entity.vo.UserOrderVo;
import com.neusoft.exception.OrderException;
import com.neusoft.service.OrderItemService;
import com.neusoft.service.ProductService;
import com.neusoft.serviceImp.OrderItemServiceImpl;
import com.neusoft.serviceImp.OrderServiceImpl;
import com.neusoft.serviceImp.ProductServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/view/order.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session=request.getSession();
Object o=session.getAttribute(Const.CURRENTUSER);
User user=null;
if(o!=null&&o instanceof User) {
	user=(User) o;
}
if(user==null) {
	response.sendRedirect(this.getServletContext().getInitParameter("hostname")+request.getContextPath()+"/login.jsp");
return;
}
String operationtype=request.getParameter("operationtype");
if(operationtype==null||operationtype.equals("")) {
	throw new OrderException("对订单操作operationtype必传");
}
OrderServiceImpl orderService=new OrderServiceImpl();
OrderItemService itemservice=new OrderItemServiceImpl();
if(operationtype.equals("1")) {//创建订单
	orderService.createOrder(user.getId(), request);
	request.getRequestDispatcher("order.do?operationtype=2&pageNo=1&pageSize=2").forward(request, response);
	
}else if(operationtype.equals("2")) {//分页查询订单
	PageModel<UserOrderVo> pagemodel=orderService.findUserOrderByPage(user.getId(), request);
request.setAttribute("Pagemodel", pagemodel);
request.getRequestDispatcher("/qiantai/order.jsp").forward(request, response);
}else if(operationtype.equals("3")) {//根据订单编号查询订单信息
	//UserOrder order=orderService.findUserOrderDetailByOrderNo(request);
		/*request.setAttribute("order", order);
	List<OrderItem> orderitems=new ArrayList<OrderItem>();
	orderitems=order.getOrderitems();
	request.setAttribute("orderitems", orderitems);
	request.getRequestDispatcher("/qiantai/orderdetail.jsp").forward(request, response);*/
	List<OrderItemVO> list=itemservice.findOrderItemByOrderNo(request);
	request.setAttribute("list", list);
	request.getRequestDispatcher("/qiantai/orderitem.jsp").forward(request, response);
}else if(operationtype.equals("4")) {//改变订单状态
	orderService.updateOrderStatusByOrderNo(request);
	request.getRequestDispatcher("order.do?operationtype=2&pageNo=1&pageSize=2").forward(request, response);
}else if(operationtype.equals("5")) {//根据订单编号查询商品详情
	ProductService ps=new ProductServiceImpl();
	String productname=request.getParameter("product_name");
	ProductVO productvo=ps.findProductByName(productname);
	request.setAttribute("product", productvo);
	request.getRequestDispatcher("/qiantai/productdetail.jsp").forward(request, response);

}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
