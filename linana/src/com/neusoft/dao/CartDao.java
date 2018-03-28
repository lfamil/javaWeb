package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;
import com.neusoft.exception.CartDaoException;

public interface CartDao {

/**
 * 根据userid和productid查询购物车信息
 * @param   userid
 * @param   productid
 * @return  Cart购物车对象
 * */
	Cart  findCartByUserIdAndProductId(Integer  userid,Integer  productid) throws CartDaoException;
	/**
	 * 更新购物车中某个商品的数量
	 * @param  userid
	 * @param productid
	 * @param quantity  商品数量
	 * @return int
	 * */
	int updateCartByUserIdAndProductId(Integer userid,Integer  productid,int quantity) throws CartDaoException;
	/**用户将商品添加到购物车
	 * @param  userid
	 *  @param productid
	 *  @param quantity  商品数量
	 *  @return int
	 * */
	int  addProductIntoCartByUserIdAndProductId(Integer userid,Integer  productid,int quantity) throws CartDaoException;
/**
 * 查看购物车的商品
 * */
	PageModel<Cart> findCartByPage(Integer userid,Integer pageNo,Integer pageSize) throws CartDaoException;
/**
 * 移除购物车某个商品
 * */
	int deleteCartByProductId(Integer userid,Integer productid) throws CartDaoException;
/**
 * 选中某个商品，取消选中   全选，取消全选
 * */
	int checkedOrNotchecked(Integer checked,Integer userid,Integer productid) throws CartDaoException;
/**
 * 查看购物车中产品数量
 * */
	int checkedQuantity(Integer userid) throws CartDaoException;
	
	/**
	 * 根据用户id查询用户在购物车中选中的商品
	 * */
	public List<Cart> findCartListByUserID(Integer userid) throws CartDaoException;
	
	/**
	 * 清空用户选中的购物车中的商品
	 * */
	int deleteCheckedProductByUserid(Integer userid);
}
