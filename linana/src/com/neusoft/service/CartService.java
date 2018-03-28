package com.neusoft.service;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.vo.CartCheckedVO;
import com.neusoft.entity.vo.CartVO;
import com.neusoft.exception.CartDaoException;

public interface CartService {
	
	/**
	 * ���ﳵ�������Ʒ
	 * @param userid
	 * @param productid
	 * @param quantity
	 * */
	public int addIntoCart(Integer userid,HttpServletRequest request) throws CartDaoException;
	/**
	 * ����userid�鿴���ﳵ
	 * */
	public PageModel<CartVO> findCartByPage(Integer userid, HttpServletRequest request) throws CartDaoException ;
/**
 * �Ƴ����ﳵ��ĳ����Ʒ
 * */
	public PageModel<CartVO> deleteCartByProductId(Integer userid, HttpServletRequest request) throws CartDaoException; 
	/**
	 * ���¹��ﳵ����Ʒ����
	 * */
	public PageModel<CartVO> updateCartByUserIdAndProductId(Integer userid, HttpServletRequest request) throws CartDaoException; 
   /**
    * ѡ��ĳ����Ʒ��ȡ��ѡ�У�ȫѡ��ȡ��ȫѡ
    * */
	public CartCheckedVO checkedOrNotchecked(Integer userid,HttpServletRequest request) throws CartDaoException ;
	/**
	 * ��ѯ���ﳵ�е���Ʒ����
	 * */
	public int checkedQuantity(Integer userid) throws CartDaoException;
}
