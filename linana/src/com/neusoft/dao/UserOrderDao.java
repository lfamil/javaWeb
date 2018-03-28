package com.neusoft.dao;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;
import com.neusoft.exception.OrderException;

public interface UserOrderDao {
/**
 * ��Ӷ���
 * @param UserOrder
 * @return int
 * */
	int addOrder(UserOrder userorder) throws OrderException;
	
	/**
	 * ��ҳ��ѯ����
	 * */
	PageModel<UserOrder> findUserOrderByPage(Integer userid,Integer pageNo,Integer PageSize)  throws OrderException;
/**
 * �������Ų�ѯ    ��������
 * */
UserOrder findUserOrderDetailByOrderNo(long orderno) throws OrderException;
/**
 * ��������    ȡ������
 * */
 int updateOrderStatusByOrderNo(long orderno,Integer status) throws OrderException;
 
}
