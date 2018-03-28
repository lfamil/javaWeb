package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.Cart;
import com.neusoft.entity.PageModel;
import com.neusoft.exception.CartDaoException;

public interface CartDao {

/**
 * ����userid��productid��ѯ���ﳵ��Ϣ
 * @param   userid
 * @param   productid
 * @return  Cart���ﳵ����
 * */
	Cart  findCartByUserIdAndProductId(Integer  userid,Integer  productid) throws CartDaoException;
	/**
	 * ���¹��ﳵ��ĳ����Ʒ������
	 * @param  userid
	 * @param productid
	 * @param quantity  ��Ʒ����
	 * @return int
	 * */
	int updateCartByUserIdAndProductId(Integer userid,Integer  productid,int quantity) throws CartDaoException;
	/**�û�����Ʒ��ӵ����ﳵ
	 * @param  userid
	 *  @param productid
	 *  @param quantity  ��Ʒ����
	 *  @return int
	 * */
	int  addProductIntoCartByUserIdAndProductId(Integer userid,Integer  productid,int quantity) throws CartDaoException;
/**
 * �鿴���ﳵ����Ʒ
 * */
	PageModel<Cart> findCartByPage(Integer userid,Integer pageNo,Integer pageSize) throws CartDaoException;
/**
 * �Ƴ����ﳵĳ����Ʒ
 * */
	int deleteCartByProductId(Integer userid,Integer productid) throws CartDaoException;
/**
 * ѡ��ĳ����Ʒ��ȡ��ѡ��   ȫѡ��ȡ��ȫѡ
 * */
	int checkedOrNotchecked(Integer checked,Integer userid,Integer productid) throws CartDaoException;
/**
 * �鿴���ﳵ�в�Ʒ����
 * */
	int checkedQuantity(Integer userid) throws CartDaoException;
	
	/**
	 * �����û�id��ѯ�û��ڹ��ﳵ��ѡ�е���Ʒ
	 * */
	public List<Cart> findCartListByUserID(Integer userid) throws CartDaoException;
	
	/**
	 * ����û�ѡ�еĹ��ﳵ�е���Ʒ
	 * */
	int deleteCheckedProductByUserid(Integer userid);
}
