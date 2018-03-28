package com.neusoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.consts.Const;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.service.AddressService;
import com.neusoft.serviceImp.AddressServiceImpl;

/**
 * Servlet implementation class AddressPageServlet
 */
@WebServlet("/AddressPage.do")
public class AddressPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession();
		Object o=session.getAttribute(Const.CURRENTUSER);
	      User user=null;
	       if(o!=null&&o instanceof User) {
	    	   user=(User) o;
	       }
	        if(user==null) {//step2:不存在用户信息，需要登录
	        	response.sendRedirect(this.getServletContext().getInitParameter("hostname")+request.getContextPath()+"/login.jsp");  	
	        
	        }else {//step3:存在用户信息
	        	
	        	String pageNo=request.getParameter("pageNo");
	    		AddressService addressservice=new AddressServiceImpl();
	    		PageModel<Address> pageModel=addressservice.findUserAddress(Integer.parseInt(pageNo), 2, user.getId());
	    		request.setAttribute("PageModel", pageModel);
	    		request.getRequestDispatcher("qiantai/address.jsp").forward(request, response);
	    
	         
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
