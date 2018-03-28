package com.neusoft.service;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.vo.ProductVO;

public interface ProductService {
	public PageModel<Product> findProductbyPage(int pageNo, int pageSize);
	public int addProduct(Product product);
	public int deleteProductById(Integer id);
	public Product findProductbyId(Integer id);
	public int updateProduct(Product product);
	public List<Product> findAllProduct();
	public ProductVO findProductByName(String productname);
}
