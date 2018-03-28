package com.neusoft.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Cate;
import com.neusoft.entity.Category;
import com.neusoft.service.CateService;
import com.neusoft.service.CategoryService;
import com.neusoft.serviceImp.CateServiceImpl;
import com.neusoft.serviceImp.CategoryServiceImpl;

/**
 * Servlet implementation class CateAddServlet
 */
@WebServlet("/CateAdd.do")
public class CateAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CateAddServlet() {
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
		CateService cs=new CateServiceImpl();
		
		List<Cate> cate=cs.findAllcate();
		request.setAttribute("cate",cate);

		request.getRequestDispatcher("mng/addCate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Category category=new Category();
		try {
			String id=request.getParameter("id");
			category.setId(Integer.parseInt(id));
			String parent_id=request.getParameter("parent_id");
			category.setParent_id(Integer.parseInt(parent_id));
			String name=request.getParameter("name");
			category.setName(name);
			String status=request.getParameter("status");
			category.setStatus(Integer.parseInt(status));
			String sort_order=request.getParameter("sort_order");
			category.setSort_order(Integer.parseInt(sort_order));
		}catch(NumberFormatException e) {
			doGet(request,response);
			return;
		}
		String create_time=request.getParameter("create_time");
		//½«×Ö·û´®×ªjava.util.Date
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date _date=format.parse(create_time);
			category.setCreate_time(_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategoryService cservice=new CategoryServiceImpl();
		 int result=cservice.addCategory(category);
		if(result>0) {
			request.getRequestDispatcher("CatePage.do?pageNo=1").forward(request, response);
		}else {
			doGet(request,response);
		}
	}

}
