package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.neusoft.entity.vo.CartCheckedVO;
import com.neusoft.entity.vo.CartVO;
import com.neusoft.entity.vo.CartVOl;
import com.neusoft.exception.CartDaoException;
import com.neusoft.service.CartService;
import com.neusoft.serviceImp.CartServiceImpl;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/Json.do")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
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
		}
		  if(user==null) {//step2:�������û���Ϣ����Ҫ��¼
	        	CartVOl vo=new CartVOl();
	       vo.setErrno(CartVOl.CART_UNLOGIN);
	      vo.setMessage("δ��¼�����¼"); 
	       Gson gson=new Gson();
	       String json=gson.toJson(vo);
	        	response.getWriter().write(callback+"("+json+")");
	        return;
	        }
		  
		  
String operation=request.getParameter("operation");
if(operation==null) {
	throw new CartDaoException("�����ﳵ���ݱ��봫��operation");
}
CartService cartservice=new CartServiceImpl();

if(operation.equals("1")) {//��ѯ
	CartVOl vo=new CartVOl();
	vo.setErrno(CartVOl.CART_SUCC);
	PrintWriter pw=response.getWriter();
	
	PageModel<CartVO> carts=cartservice.findCartByPage(user.getId(), request);
	vo.setPagemodel(carts);
	
	//����תjson�ַ���
	Gson gson=new Gson();
	String result=gson.toJson(vo);
	
	System.out.println(result);

	pw.write(callback+"("+result+")");
}else if(operation.equals("2")) {//���
	
}else if(operation.equals("3")) {//ɾ��
	CartVOl vo=new CartVOl();
	vo.setErrno(CartVOl.CART_SUCC);
	PageModel<CartVO> carts=cartservice.deleteCartByProductId(user.getId(), request);
	vo.setPagemodel(carts);
	Gson gson=new Gson();
	String result=gson.toJson(vo);
	System.out.println(result);
	
	response.getWriter().write(callback+"("+result+")");
}else if(operation.equals("4")) {//��ѯ���ﳵ��Ʒ������
	int totalquantity=cartservice.checkedQuantity(user.getId());
	String json="{\"totalquantity\":"+totalquantity+"}";
	response.getWriter().write(callback+"("+json+")");
}else if(operation.equals("5")) {//ȫѡ����ѡ  ȡ��ȫѡ��ѡ
	System.out.println(request.getParameter("checked"));
	CartCheckedVO vo=cartservice.checkedOrNotchecked(user.getId(), request);
	System.out.println(vo);
	Gson gson=new Gson();
	String result=gson.toJson(vo);
	System.out.println(result);
	
	response.getWriter().write(callback+"("+result+")");

}else if(operation.equals("6")) {//������Ʒ����
	CartVOl vo=new CartVOl();
	vo.setErrno(CartVOl.CART_SUCC);
	PageModel<CartVO> carts=cartservice.updateCartByUserIdAndProductId(user.getId(), request);
	vo.setPagemodel(carts);
	Gson gson=new Gson();
	String result=gson.toJson(vo);
	System.out.println(result);
	
	response.getWriter().write(callback+"("+result+")");
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
