package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;

public interface Productdao {
	public PageModel<Product> findProductbyPage(int pageNo,int pageSize);
public int addProduct(Product product);
public int deleteProductByid(Integer id);
public Product findProductbyId(Integer id);
public int updateProduct(Product product);
public List<Product> findAllProduct();
/**
 * 按商品类别检索商品
 * */
List<Product> searchProduct(String categoryname);
/**
 * 根据商品id查询商品库存
 * */
Long getProductStock(Integer id);
/**
 * 减少商品库存
 * */
int reduceproductStock(Integer id,Integer quantity);
/**
 * 按商品名称检索商品信息
 * */
Product findProductByName(String productname);
}
