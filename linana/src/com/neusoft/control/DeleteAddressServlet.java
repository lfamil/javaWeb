package com.neusoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.consts.Const;
import com.neusoft.entity.User;
import com.neusoft.service.AddressService;
import com.neusoft.serviceImp.AddressServiceImpl;

/**
 * Servlet implementation class DeleteAddressServlet
 */
@WebServlet("/DeleteAddress.do")
public class DeleteAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAddressServlet() {
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
		 String id=request.getParameter("id");
		AddressService addrservice=new AddressServiceImpl();
		addrservice.deleteAddressByUserid(user.getId(), Integer.parseInt(id));
		
		 
		request.getRequestDispatcher("AddressPage.do?pageNo=1").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
