package com.neusoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.consts.Const;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.entity.vo.CartVO;
import com.neusoft.exception.CartDaoException;
import com.neusoft.service.CartService;
import com.neusoft.serviceImp.CartServiceImpl;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/view/cart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//step1:从回话中获取用户信息
		HttpSession session=request.getSession();
       Object o=session.getAttribute(Const.CURRENTUSER);
      User user=null;
       if(o!=null&&o instanceof User) {
    	   user=(User) o;
    	   request.setAttribute("user", user);
       }
        if(user==null) {//step2:不存在用户信息，需要登录
        	response.sendRedirect(this.getServletContext().getInitParameter("hostname")+request.getContextPath()+"/login.jsp");  	
        return;
        }
        CartService cartservice=new CartServiceImpl();
       String operation=request.getParameter("operation");
        Integer operationtype=0;
        try {
        	operationtype=Integer.parseInt(operation);
        }catch(NumberFormatException e) {
        	e.printStackTrace();
        }
        if(operationtype==0) {
        	throw new CartDaoException("必须传入操作类型");
        }else if(operationtype==1) {//分页查询
        	PageModel<CartVO> carts=cartservice.findCartByPage(user.getId(), request);
        	request.setAttribute("PageModel", carts);
        	request.getRequestDispatcher("/qiantai/cart.jsp").forward(request, response);
        }else if(operationtype==2) {//添加商品到购物车
        	
        	cartservice.addIntoCart(user.getId(), request);
        	request.getRequestDispatcher("cart.do?operation=1&pageNo=1&pageSize=2&userid=user.getId()").forward(request, response);
        	
        }else if(operationtype==3) {//删除购物车里的商品
        	cartservice.deleteCartByProductId(user.getId(), request);
        	
        	request.getRequestDispatcher("cart.do?operation=1&pageNo=1&pageSize=2&userid=user.getId()").forward(request, response);
        	
        }else if(operationtype==4) {//更新购物车中某个商品的数量
        	cartservice.updateCartByUserIdAndProductId(user.getId(), request);
        	request.getRequestDispatcher("cart.do?operation=1&pageNo=1&pageSize=2&userid=user.getId()").forward(request, response);

        }else if(operationtype==5) {//选中，取消选中，全选，取消全选，
        	cartservice.checkedOrNotchecked(user.getId(), request);
        }else if(operationtype==6) {//查询购物车中商品总数量
        	int totalQuantity=cartservice.checkedQuantity(user.getId());
        	request.setAttribute("totalQuantity", totalQuantity);
        	
        	request.getRequestDispatcher("/qiantai/quantity.jsp").forward(request, response);
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
