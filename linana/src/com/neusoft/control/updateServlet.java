package com.neusoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.User;
import com.neusoft.service.Servicelogin;
import com.neusoft.serviceImp.ServiceloginImp;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/update.do")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		Servicelogin service=new ServiceloginImp();
		
		try{
		User user=service.findUserbyid(Integer.parseInt(id));
		if(user!=null) {
			request.setAttribute("user", user);
		
			request.getRequestDispatcher("mng/update.jsp").forward(request, response);

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
		
		User user=new User();
		try {
			String id=request.getParameter("id");
		    user.setId(Integer.parseInt(id));
				String username=request.getParameter("username");
				user.setUsername(username);
				String password=request.getParameter("password");
				user.setPassword(password);
				String email=request.getParameter("email");
				user.setEmail(email);
				String phone=request.getParameter("phone");
				user.setPhone(phone);
				String question=request.getParameter("question");
				user.setQuestion(question);
				String answer=request.getParameter("answer");
				user.setAnswer(answer);
				String role=request.getParameter("role");
				user.setRole(Integer.parseInt(role));
				
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		
	
		
	 Servicelogin servicedao=new ServiceloginImp();
	 servicedao.updateUser(user);

		request.getRequestDispatcher("user.do").forward(request, response);
	
	}

}
