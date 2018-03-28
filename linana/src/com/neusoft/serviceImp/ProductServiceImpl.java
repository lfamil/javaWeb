package com.neusoft.serviceImp;

import java.util.List;

import com.neusoft.dao.Productdao;
import com.neusoft.daoImp.ProductDaoBatisImpl;
import com.neusoft.daoImp.ProductdaoImpl;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.neusoft.entity.vo.ProductVO;
import com.neusoft.exception.ProductException;
import com.neusoft.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public PageModel<Product> findProductbyPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Productdao productdao=ProductdaoImpl.getInstance();
		return productdao.findProductbyPage(pageNo, pageSize);
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		Productdao productdao=ProductdaoImpl.getInstance();
		return productdao.addProduct(product);
	}

	@Override
	public int deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		Productdao productdao=ProductdaoImpl.getInstance();
		return productdao.deleteProductByid(id);
	}

	@Override
	public Product findProductbyId(Integer id) {
		// TODO Auto-generated method stub
		Productdao productdao=ProductdaoImpl.getInstance();
		return productdao.findProductbyId(id);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		Productdao productdao=ProductdaoImpl.getInstance();
		return productdao.updateProduct(product);
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		Productdao productdao=ProductdaoImpl.getInstance();
		return productdao.findAllProduct();
	}

	@Override
	public ProductVO findProductByName(String productname) {
		// TODO Auto-generated method stub
		Productdao productdao=new ProductDaoBatisImpl();
	Product product=productdao.findProductByName(productname);
	if(product==null) {
		throw new ProductException("该商品已下架");
	}
	System.out.println(product);
	ProductVO productvo=new ProductVO();
		return productvo.convertProductToVo(product);
	}

}
