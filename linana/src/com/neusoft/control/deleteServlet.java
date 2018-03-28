package com.neusoft.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.User;
import com.neusoft.service.Servicelogin;
import com.neusoft.serviceImp.ServiceloginImp;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/delete.do")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
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
		String _id=request.getParameter("id");
		Servicelogin servicedao=new ServiceloginImp();
		try {
			servicedao.deleteUserByid(Integer.parseInt(_id));	
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		List<User> user=servicedao.findUser();
		request.setAttribute("users",user);
		request.getRequestDispatcher("mng/User.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
