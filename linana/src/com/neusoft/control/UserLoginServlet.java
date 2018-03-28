package com.neusoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.consts.Const;
import com.neusoft.entity.User;
import com.neusoft.service.Servicelogin;
import com.neusoft.serviceImp.ServiceloginImp;
import com.nuesoft.common.MD5Utils;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/User/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession();
		String tokens=null;
	
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			
		for(Cookie c:cookies) {
			if(c.getName().equals(Const.TOKEN_COOKIE)) {
				tokens=c.getValue();
			}
		}
		}
		if(tokens!=null) {
			 Servicelogin sl=new ServiceloginImp();
				User user=sl.findUserByToken(tokens);
				if(user!=null) {
					session.setAttribute(Const.CURRENTUSER, user);
response.sendRedirect("http://localhost:8080/linana/mng/header.jsp");	
return;
				}
		}
		
		/*if(session.isNew()) {
			System.out.println("这是一个新的回话");
		}else {
			System.out.println("这是一个已经存在的回话");
		}*/
		//获取表单参数
	
		String username=request.getParameter(Const.USERNAME_COOKIE);
		String password=request.getParameter(Const.PASSWORD_COOKIE);
		if(password!=null) {
			password=MD5Utils.GetMD5Code(password);
		}
      Servicelogin sl=new ServiceloginImp();
		User user=sl.login(username, password);
		
		if(user!=null) {
			//令牌
			String token=MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
			Cookie token_cookie=new Cookie(Const.TOKEN_COOKIE,token);
			token_cookie.setMaxAge(24*3600);
			token_cookie.setPath(request.getContextPath());
			response.addCookie(token_cookie);
     sl.updateTokenByUserId(user.getId(), token);
session.setAttribute(Const.CURRENTUSER, user);
    response.sendRedirect("http://localhost:8080/linana/mng/header.jsp");	
		}else {
			
			
			request.getRequestDispatcher("/mng/fail.jsp").forward(request, response);
		}
		
		
		
	}

}
