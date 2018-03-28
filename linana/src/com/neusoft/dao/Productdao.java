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
 * ����Ʒ��������Ʒ
 * */
List<Product> searchProduct(String categoryname);
/**
 * ������Ʒid��ѯ��Ʒ���
 * */
Long getProductStock(Integer id);
/**
 * ������Ʒ���
 * */
int reduceproductStock(Integer id,Integer quantity);
/**
 * ����Ʒ���Ƽ�����Ʒ��Ϣ
 * */
Product findProductByName(String productname);
}
