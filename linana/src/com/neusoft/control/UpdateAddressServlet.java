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
import com.neusoft.entity.User;
import com.neusoft.service.AddressService;
import com.neusoft.serviceImp.AddressServiceImpl;

/**
 * Servlet implementation class UpdateAddressServlet
 */
@WebServlet("/UpdateAddress.do")
public class UpdateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddressServlet() {
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
		String id=request.getParameter("id");
		AddressService addservice=new AddressServiceImpl();
		try{
		Address address=addservice.findAddressByid(Integer.parseInt(id),user.getId());
		if(address!=null) {
			request.setAttribute("address", address);
		
			request.getRequestDispatcher("qiantai/updateAddress.jsp").forward(request, response);

		}	
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session=request.getSession();
	       Object o=session.getAttribute(Const.CURRENTUSER);
	      User user=null;
	       if(o!=null&&o instanceof User) {
	    	   user=(User) o;
	       }
		Address address=new Address();
	try {
			String id=request.getParameter("id");
		      address.setId(Integer.parseInt(id));
			
		      String receiver_name=request.getParameter("receiver_name");
				address.setReceiver_name(receiver_name);
				String receiver_phone=request.getParameter("receiver_phone");
				address.setReceiver_phone(receiver_phone);
				String receiver_mobile=request.getParameter("receiver_mobile");
				address.setReceiver_mobile(receiver_mobile);
				String receiver_province=request.getParameter("receiver_province");
				address.setReceiver_province(receiver_province);
				String receiver_city=request.getParameter("receiver_city");
				address.setReceiver_city(receiver_city);
				String receiver_district=request.getParameter("receiver_district");
				address.setReceiver_district(receiver_district);
				String receiver_address=request.getParameter("receiver_address");
				address.setReceiver_address(receiver_address);
				String receiver_zip=request.getParameter("receiver_zip");
				address.setReceiver_zip(receiver_zip);
	}catch(NumberFormatException e) {
		doGet(request,response);
		
		return;
	}
		
		AddressService addservice=new AddressServiceImpl();
		addservice.updateAddressByUserid(user.getId(), address);
	
		
			request.getRequestDispatcher("AddressPage.do?pageNo=1").forward(request, response);
		
		
	}

}
