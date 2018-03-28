package com.neusoft.service;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;
import com.neusoft.entity.vo.UserOrderVo;
import com.neusoft.exception.OrderException;

public interface IOrderService {
/**
 * �û��µ�
 * @param  user_id
 * @param request  ��ȡ���͵�ַ
 * */
	UserOrder createOrder(Integer user_id,HttpServletRequest request) throws OrderException;
/**
 * ��ҳ��ѯ
 * */
PageModel<UserOrderVo> findUserOrderByPage(Integer user_id,HttpServletRequest request) throws OrderException;
/**
 * ���ݶ�����Ų�ѯ ��������
 * */
public UserOrder findUserOrderDetailByOrderNo(HttpServletRequest request) throws OrderException;
/**
 * ����������ȡ������
 * */
public int updateOrderStatusByOrderNo(HttpServletRequest request) throws OrderException;

}
