package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.neusoft.consts.Const;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.entity.vo.Ordervol;
import com.neusoft.entity.vo.UserOrderVo;
import com.neusoft.exception.CartDaoException;
import com.neusoft.service.IOrderService;
import com.neusoft.serviceImp.OrderServiceImpl;

/**
 * Servlet implementation class ViewOrderServlet
 */
@WebServlet("/ViewOrder.do")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderServlet() {
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
		String callback=request.getParameter("callback");
		HttpSession session=request.getSession();
		Object o=session.getAttribute(Const.CURRENTUSER);
		User user=null;
		if(o!=null&o instanceof User) {
			user=(User) o;
		}if(user==null) {//step2:不存在用户信息，需要登录
        	Ordervol vo=new Ordervol();
       vo.setErrno(Ordervol.ORDER_UNLOGIN);
      vo.setMessage("未登录，请登录"); 
       Gson gson=new Gson();
       String json=gson.toJson(vo);
        	response.getWriter().write(callback+"("+json+")");
        return;
        }
		  
		  
		  String operation=request.getParameter("operation");
		  if(operation==null) {
		  	throw new CartDaoException("请求购物车数据必须传入operation");
		  }
		  IOrderService orderservice=new OrderServiceImpl();
		  if(operation.equals("1")) {//创建订单
			  orderservice.createOrder(user.getId(), request);
			  
		  }else if(operation.equals("2")) {
			  Ordervol vo=new Ordervol();
			  vo.setErrno(Ordervol.ORDER_SUCC);
			  PageModel<UserOrderVo> pagemodel= orderservice.findUserOrderByPage(user.getId(), request);
			 vo.setPagemodel(pagemodel);
			  Gson gson=new Gson();
				String data=gson.toJson(vo);
				response.getWriter().write(callback+"("+data+")");
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
