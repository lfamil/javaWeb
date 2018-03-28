package com.neusoft.control;

import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.User;
import com.neusoft.service.Servicelogin;
import com.neusoft.serviceImp.ServiceloginImp;
import com.nuesoft.common.MD5Utils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("mng/register.jsp").forward(request, response);
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
			/*String id=request.getParameter("id");
		      user.setId(Integer.parseInt(id));*/
				String username=request.getParameter("username");
				user.setUsername(username);
				String password=request.getParameter("password");
				user.setPassword(MD5Utils.GetMD5Code(password));
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
			doGet(request,response);
			return;
		}
		
	/**	String create_time=request.getParameter("create_time");
		//String update_time=request.getParameter("update_time");
		//½«×Ö·û´®×ªjava.util.Date
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date _date=format.parse(create_time);
			user.setCreate_time(_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	 Servicelogin servicedao=new ServiceloginImp();
	 int result=servicedao.addUser(user);
	if(result>0) {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}else {
		doGet(request,response);
	}
	}

}
