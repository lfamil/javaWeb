package com.neusoft.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neusoft.dao.Productdao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.Product;
import com.nuesoft.common.MyBatisUtils;

public class ProductDaoBatisImpl implements Productdao {

	@Override
	public PageModel<Product> findProductbyPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProductByid(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product findProductbyId(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Product product=session.selectOne("com.neusoft.entity.Product.findProductbyId",id);
		return product;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProduct(String categoryname) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,String> map=new HashMap<String,String>();
		map.put("categoryname", categoryname);
		List<Product> list=session.selectList("com.neusoft.entity.Product.searchProduct", map);
		session.close();
		return list;
	}

	@Override
	public Long getProductStock(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Long row=session.selectOne("com.neusoft.entity.Product.getProductStock",id);
		session.close();
		return row;
	}

	@Override
	public int reduceproductStock(Integer id, Integer quantity) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("id", id);
		map.put("quantity", quantity);
		
	int row=session.update("com.neusoft.entity.Product.reduceProductStock", map);
		session.close();
		return row;
	}

	@Override
	public Product findProductByName(String productname) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Product product=session.selectOne("com.neusoft.entity.Product.findProductByName",productname);
		session.close();
		return product;
	}

}
