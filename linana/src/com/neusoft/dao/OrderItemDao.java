package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.OrderItem;
import com.neusoft.entity.Product;
import com.neusoft.exception.OrderItemException;

public interface OrderItemDao {
/**
 * 将订单明细批量插入到数据库
 * */
	
	int addBatch(List<OrderItem> orderitems) throws OrderItemException;
/**
 * 获取订单的商品信息
 * */
List<OrderItem> findOrderItemByOrderNo(long orderno) throws OrderItemException;

Product findProductByProductname(String productname)  throws OrderItemException;
}
