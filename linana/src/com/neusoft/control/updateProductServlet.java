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
 * Servlet implementation class updateProductServlet
 */
@WebServlet("/updateProduct.do")
public class updateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		ProductService pservice=new ProductServiceImpl();
		 CategoryService cateservice=new CategoryServiceImpl();
			
			List<Category> category=cateservice.findAllCate();
			request.setAttribute("category",category);
		try{
		Product product=pservice.findProductbyId(Integer.parseInt(id));
		if(product!=null) {
			request.setAttribute("product", product);
		
			request.getRequestDispatcher("mng/updateProduct.jsp").forward(request, response);

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
			System.out.println("shibai");
			e.printStackTrace();
			
		}
		
		
		 ProductService pservice=new ProductServiceImpl();
		pservice.updateProduct(product);
		 System.out.println("³É¹¦");
		
			request.getRequestDispatcher("page.do?pageNo=1").forward(request, response);
		
		
	
	
	}

}
