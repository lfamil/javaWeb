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
		//step1:�ӻػ��л�ȡ�û���Ϣ
		HttpSession session=request.getSession();
       Object o=session.getAttribute(Const.CURRENTUSER);
      User user=null;
       if(o!=null&&o instanceof User) {
    	   user=(User) o;
    	   request.setAttribute("user", user);
       }
        if(user==null) {//step2:�������û���Ϣ����Ҫ��¼
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
        	throw new CartDaoException("���봫���������");
        }else if(operationtype==1) {//��ҳ��ѯ
        	PageModel<CartVO> carts=cartservice.findCartByPage(user.getId(), request);
        	request.setAttribute("PageModel", carts);
        	request.getRequestDispatcher("/qiantai/cart.jsp").forward(request, response);
        }else if(operationtype==2) {//�����Ʒ�����ﳵ
        	
        	cartservice.addIntoCart(user.getId(), request);
        	request.getRequestDispatcher("cart.do?operation=1&pageNo=1&pageSize=2&userid=user.getId()").forward(request, response);
        	
        }else if(operationtype==3) {//ɾ�����ﳵ�����Ʒ
        	cartservice.deleteCartByProductId(user.getId(), request);
        	
        	request.getRequestDispatcher("cart.do?operation=1&pageNo=1&pageSize=2&userid=user.getId()").forward(request, response);
        	
        }else if(operationtype==4) {//���¹��ﳵ��ĳ����Ʒ������
        	cartservice.updateCartByUserIdAndProductId(user.getId(), request);
        	request.getRequestDispatcher("cart.do?operation=1&pageNo=1&pageSize=2&userid=user.getId()").forward(request, response);

        }else if(operationtype==5) {//ѡ�У�ȡ��ѡ�У�ȫѡ��ȡ��ȫѡ��
        	cartservice.checkedOrNotchecked(user.getId(), request);
        }else if(operationtype==6) {//��ѯ���ﳵ����Ʒ������
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
