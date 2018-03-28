package com.neusoft.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neusoft.dao.OrderItemDao;
import com.neusoft.entity.OrderItem;
import com.neusoft.entity.Product;
import com.neusoft.exception.OrderItemException;
import com.nuesoft.common.MyBatisUtils;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public int addBatch(List<OrderItem> orderitems) throws OrderItemException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession(true);
		int row=sqlsession.insert("com.neusoft.entity.OrderItem.addBatch", orderitems);
		
		sqlsession.close();
		return row;
	}

	@Override
	public List<OrderItem> findOrderItemByOrderNo(long orderno) throws OrderItemException {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession(false);
		List<OrderItem> list=sqlsession.selectList("com.neusoft.entity.OrderItem.findOrderItemByOrderNo", orderno);
		sqlsession.commit();
		sqlsession.close();
		return list;
	}

	@Override
	public Product findProductByProductname(String productname) throws OrderItemException {
		// TODO Auto-generated method stub
		
		return null;
	}

}
