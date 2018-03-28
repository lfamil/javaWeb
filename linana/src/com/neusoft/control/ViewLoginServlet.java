package com.neusoft.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.neusoft.consts.Const;
import com.neusoft.entity.User;
import com.neusoft.entity.vo.LoginVO;
import com.neusoft.service.Servicelogin;
import com.neusoft.serviceImp.ServiceloginImp;
import com.nuesoft.common.MD5Utils;

/**
 * Servlet implementation class ViewLoginServlet
 */
@WebServlet("/view/login")
public class ViewLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLoginServlet() {
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
	/*String tokens=null;
	
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
response.sendRedirect("http://127.0.0.1:8020/project/shopmall.html");	
return;
				}
		}
	*/
		/*if(session.isNew()) {
			System.out.println("这是一个新的回话");
		}else {
			System.out.println("这是一个已经存在的回话");
		}*/
		//获取表单参数
		String callback=request.getParameter("callback");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
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
     //用户放到回话中
session.setAttribute(Const.CURRENTUSER, user);


  LoginVO loginvo=new LoginVO();
  loginvo.setErrno(LoginVO.LOGIN_SUCC);
  loginvo.setUser(user);
  Gson gson=new Gson();
  String json=gson.toJson(loginvo);
  System.out.println(json);
  response.getWriter().write(callback+"("+json+")");
		}else {
			//登录失败
			LoginVO loginvo=new LoginVO();
			  loginvo.setErrno(LoginVO.LOGIN_FAIL);
			  loginvo.setMessage("登录失败");
			  Gson gson=new Gson();
			  String json=gson.toJson(loginvo);
			  System.out.println(json);
			  response.getWriter().write(callback+"("+json+")");
		}
		
		
		
	}
	}


