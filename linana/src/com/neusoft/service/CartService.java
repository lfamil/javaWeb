package com.neusoft.service;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.vo.CartCheckedVO;
import com.neusoft.entity.vo.CartVO;
import com.neusoft.exception.CartDaoException;

public interface CartService {
	
	/**
	 * 购物车中添加商品
	 * @param userid
	 * @param productid
	 * @param quantity
	 * */
	public int addIntoCart(Integer userid,HttpServletRequest request) throws CartDaoException;
	/**
	 * 根据userid查看购物车
	 * */
	public PageModel<CartVO> findCartByPage(Integer userid, HttpServletRequest request) throws CartDaoException ;
/**
 * 移除购物车中某个商品
 * */
	public PageModel<CartVO> deleteCartByProductId(Integer userid, HttpServletRequest request) throws CartDaoException; 
	/**
	 * 更新购物车中商品数量
	 * */
	public PageModel<CartVO> updateCartByUserIdAndProductId(Integer userid, HttpServletRequest request) throws CartDaoException; 
   /**
    * 选中某个商品，取消选中，全选，取消全选
    * */
	public CartCheckedVO checkedOrNotchecked(Integer userid,HttpServletRequest request) throws CartDaoException ;
	/**
	 * 查询购物车中的商品总数
	 * */
	public int checkedQuantity(Integer userid) throws CartDaoException;
}
