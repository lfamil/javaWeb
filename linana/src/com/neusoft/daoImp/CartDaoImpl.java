package com.neusoft.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neusoft.dao.CartDao;
import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;
import com.neusoft.exception.CartDaoException;
import com.nuesoft.common.MyBatisUtils;

public class CartDaoImpl implements CartDao {
	public static CartDaoImpl cartdao=null;
	private CartDaoImpl() {}
	public static CartDaoImpl getInstance() {
		synchronized(CategorydaoImpl.class){
		if(cartdao==null) {
			cartdao=new CartDaoImpl();
		}
		}
		return cartdao;
	}
	@Override
	//根据userid和productid查询购物车信息
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
	
		Cart cart=session.selectOne("com.neusoft.entity.Cart.findCartByUserIdAndProductId", map);
		session.close();
		return cart;
	}

	@Override
	// 更新购物车中商品的数量
	public int updateCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		map.put("quantity", quantity);
		int result=session.update("com.neusoft.entity.Cart.updateCartByUserIdAndProductId", map);
		session.close();
		return result;
		
	}

	@Override
	//用户将商品添加到购物车
	public int addProductIntoCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		map.put("quantity", quantity);
		int result=session.insert("com.neusoft.entity.Cart.addProductIntoCartByUserIdAndProductId", map);
		session.close();
		return result;
	}
	@Override
	//分页查询
	public PageModel<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int totalcount=	session.selectOne("com.neusoft.entity.Cart.findTotalCount",userid);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("userid", userid);
		PageModel<Cart> pagemodel=null;
		if(totalcount>0) {
	 pagemodel=new PageModel<Cart>();
		List<Cart> list=session.selectList("com.neusoft.entity.Cart.findCartByPage", map);
		
		pagemodel.setTotalpage(totalcount%pageSize==0?totalcount/pageSize:totalcount/pageSize+1);
		pagemodel.setData(list);}
		session.close();
		return pagemodel;
	}
	@Override
	//移除购物车中某个商品
	public int deleteCartByProductId(Integer userid, Integer productid) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
	
		int result=session.update("com.neusoft.entity.Cart.deleteCartByProductId", map);
		session.close();
		return result;
	}
	@Override
	//选中，取消选中   全选，取消全选
	public int checkedOrNotchecked(Integer checked, Integer userid, Integer productid) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		map.put("checked", checked);
	int result=	session.update("com.neusoft.entity.Cart.checkedOrNotchecked", map);
	session.close();
		return result;
	}
	@Override
	//查询购物车商品总数
	public int checkedQuantity(Integer userid) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int result=session.selectOne("com.neusoft.entity.Cart.checkedQuantity", userid);
		return result;
	}
	@Override
	public List<Cart> findCartListByUserID(Integer userid) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		List<Cart> carts=session.selectList("com.neusoft.entity.Cart.findCartListByUserID", userid);
		return carts;
	}
	@Override
	public int deleteCheckedProductByUserid(Integer userid) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int result=session.delete("com.neusoft.entity.Cart.deleteCheckedProduct", userid);
		session.close();
		return result;
	}
	
	
	

}
