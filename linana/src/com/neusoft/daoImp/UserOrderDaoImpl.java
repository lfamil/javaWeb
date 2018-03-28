package com.neusoft.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neusoft.dao.UserOrderDao;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.UserOrder;
import com.neusoft.exception.OrderException;
import com.nuesoft.common.MyBatisUtils;

public class UserOrderDaoImpl implements UserOrderDao {

	@Override
	public int addOrder(UserOrder userorder) throws OrderException {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession(true);
		int result=sqlsession.insert("com.neusoft.entity.UserOrder.addOrder", userorder);
		sqlsession.close();
		return result;
	}

	@Override
	public PageModel<UserOrder> findUserOrderByPage(Integer userid, Integer pageNo, Integer PageSize)
			throws OrderException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("offset", (pageNo-1)*PageSize);
		map.put("pageSize",PageSize);
		Integer totalcount=session.selectOne("com.neusoft.entity.UserOrder.findTotalPage", userid);
		List<UserOrder> orders=session.selectList("com.neusoft.entity.UserOrder.findOrderByPage", map);
		PageModel<UserOrder> pagemodel=new PageModel<UserOrder>();
		
		int totalpage=(totalcount%PageSize==0?totalcount/PageSize:totalcount/PageSize+1);
		pagemodel.setData(orders);
		pagemodel.setTotalpage(totalpage);
		return pagemodel;
	}

	@Override
	public UserOrder findUserOrderDetailByOrderNo(long orderno) throws OrderException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(false);
		UserOrder userorder=session.selectOne("com.neusoft.entity.UserOrder.findUserOrderDetailByOrderNo",orderno);
		session.close();
		return userorder;
	}

	@Override
	public int updateOrderStatusByOrderNo(long orderno,Integer status) throws OrderException {
		// TODO Auto-generated method stu
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("orderno", orderno);
		map.put("status", status);
		
		
		int result=session.update("com.neusoft.entity.UserOrder.updateOrderStatusByOrderNo",map);
		session.close();
		return result;
	}

}
