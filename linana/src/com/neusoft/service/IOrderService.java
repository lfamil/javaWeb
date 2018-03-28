package com.neusoft.service;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;
import com.neusoft.entity.vo.UserOrderVo;
import com.neusoft.exception.OrderException;

public interface IOrderService {
/**
 * 用户下单
 * @param  user_id
 * @param request  获取配送地址
 * */
	UserOrder createOrder(Integer user_id,HttpServletRequest request) throws OrderException;
/**
 * 分页查询
 * */
PageModel<UserOrderVo> findUserOrderByPage(Integer user_id,HttpServletRequest request) throws OrderException;
/**
 * 根据订单编号查询 订单详情
 * */
public UserOrder findUserOrderDetailByOrderNo(HttpServletRequest request) throws OrderException;
/**
 * 订单发货，取消订单
 * */
public int updateOrderStatusByOrderNo(HttpServletRequest request) throws OrderException;

}
