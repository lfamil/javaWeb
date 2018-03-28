package com.neusoft.dao;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;
import com.neusoft.exception.OrderException;

public interface UserOrderDao {
/**
 * 添加订单
 * @param UserOrder
 * @return int
 * */
	int addOrder(UserOrder userorder) throws OrderException;
	
	/**
	 * 分页查询订单
	 * */
	PageModel<UserOrder> findUserOrderByPage(Integer userid,Integer pageNo,Integer PageSize)  throws OrderException;
/**
 * 按订单号查询    订单详情
 * */
UserOrder findUserOrderDetailByOrderNo(long orderno) throws OrderException;
/**
 * 订单发货    取消订单
 * */
 int updateOrderStatusByOrderNo(long orderno,Integer status) throws OrderException;
 
}
