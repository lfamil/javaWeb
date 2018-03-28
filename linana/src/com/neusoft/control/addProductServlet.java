package com.neusoft.control;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.entity.Category;
import com.neusoft.entity.Product;
import com.neusoft.service.CategoryService;
import com.neusoft.service.ProductService;
import com.neusoft.serviceImp.CategoryServiceImpl;
import com.neusoft.serviceImp.ProductServiceImpl;

/**
 * Servlet implementation class addProductServlet
 */
@WebServlet("/addProduct.do")
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProductServlet() {
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
		 CategoryService cateservice=new CategoryServiceImpl();
		
		List<Category> category=cateservice.findAllCate();
		request.setAttribute("category",category);
	
		request.getRequestDispatcher("mng/addp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Product product=new Product();
	try {
			String id=request.getParameter("id");
		      product.setId(Integer.parseInt(id));
				String name=request.getParameter("name");
				product.setName(name);
				String category_name=request.getParameter("category_name");
				product.setCategory_name(category_name);
				String subtitle=request.getParameter("subtitle");
				product.setSubtitle(subtitle);
				String main_image=request.getParameter("main_image");
				product.setMain_image(main_image);
				String sub_images=request.getParameter("sub_images");
				product.setSub_images(sub_images);
				String detail=request.getParameter("detail");
				product.setDetail(detail);
				String stock=request.getParameter("stock");
				product.setStock(Integer.parseInt(stock));
				String status=request.getParameter("status");
				product.setStatus(status);
				String price=request.getParameter("price");
				BigDecimal bd=new BigDecimal(price);
				product.setPrice(bd);
	}catch(NumberFormatException e) {
		doGet(request,response);
		
		return;
	}
		
		
		
		/**String create_time=request.getParameter("create_time");
		
		//将字符串转java.util.Date
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date create_date=format.parse(create_time);
			product.setCreate_time(create_date);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	 ProductService pservice=new ProductServiceImpl();
	 int result=pservice.addProduct(product);
	
	if(result>0) {
		System.out.println("插入成功");
		request.getRequestDispatcher("page.do?pageNo=1").forward(request, response);
	}else {
		
		doGet(request,response);
	}
	
	}


}
