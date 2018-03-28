package com.neusoft.control;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.consts.Const;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//step1:需要将登陆信息user从回话中删除
		HttpSession session=request.getSession();
		
		session.removeAttribute(Const.CURRENTUSER);
		//step2:把name和password的cookie移除
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals(Const.TOKEN_COOKIE)) {
					Cookie c1=new Cookie(c.getName(),c.getValue());
					c1.setMaxAge(0);
					c1.setPath(request.getContextPath());
					response.addCookie(c1);
					}
					
			}
			
		}
		ServletContext application=this.getServletContext();
		String value=application.getInitParameter("hostname");
		String result=value+request.getContextPath()+"/login.jsp";
		response.getWriter().print("<script>top.location.href=\""+result+"\"</script>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
