package com.neusoft.fliter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.consts.Const;
import com.neusoft.entity.User;
import com.neusoft.service.Servicelogin;
import com.neusoft.serviceImp.ServiceloginImp;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/mng/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpServletRequest request=(HttpServletRequest) _request;
		HttpServletResponse response=(HttpServletResponse) _response;
		//判断用户cookie是否存在
		HttpSession session=request.getSession();
		
		String token=null;
		
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
		for(Cookie c:cookies) {
			if(c.getName().equals(Const.TOKEN_COOKIE)) {
				token=c.getValue();
			}
		}
		}
		if(token!=null) {
			 Servicelogin sl=new ServiceloginImp();
				User user=sl.findUserByToken(token);
				if(user!=null) {
					session.setAttribute("user", user);
					chain.doFilter(request, response);
	
                     return;
				}else {
					response.sendRedirect("http://localhost:8080/linana/login.jsp");
				}
		}else {
			response.sendRedirect("http://localhost:8080/linana/login.jsp");

		}
		
		
		
		//存在，获取用户名和密码，校验
		//不存在，跳转到登录页面
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
