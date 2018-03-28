package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.OrderItem;
import com.neusoft.entity.Product;
import com.neusoft.exception.OrderItemException;

public interface OrderItemDao {
/**
 * ��������ϸ�������뵽���ݿ�
 * */
	
	int addBatch(List<OrderItem> orderitems) throws OrderItemException;
/**
 * ��ȡ��������Ʒ��Ϣ
 * */
List<OrderItem> findOrderItemByOrderNo(long orderno) throws OrderItemException;

Product findProductByProductname(String productname)  throws OrderItemException;
}
