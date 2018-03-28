package com.neusoft.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neusoft.dao.AddressDao;
import com.neusoft.entity.Address;
import com.neusoft.entity.PageModel;
import com.nuesoft.common.MyBatisUtils;

public class AddressdaoImpl implements AddressDao {

	public static AddressdaoImpl addressdao=null;
	private AddressdaoImpl() {}
	public static AddressdaoImpl getInstance() {
		synchronized(CategorydaoImpl.class){
		if(addressdao==null) {
			addressdao=new AddressdaoImpl();
		}
		}
		return addressdao;
	}
	@Override
	public int addAddress(Integer userid, Address address) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("address", address);
		int result=sqlsession.insert("com.neusoft.entity.Address.addAddress", map);
		MyBatisUtils.close(sqlsession);
		return result;
	
	}

	@Override
	public int deleteAddressByUserid(Integer userid, Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession(true);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("id", id);
		int result=sqlsession.delete("com.neusoft.entity.Address.deleteAddressByUserid", map);
		MyBatisUtils.close(sqlsession);
		return result;
		
	}

	@Override
	public int updateAddressByUserid(Integer userid, Address address) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("address", address);
		int result=sqlsession.update("com.neusoft.entity.Address.updateAddressByUserid", map);
		MyBatisUtils.close(sqlsession);
		return result;
		
	}

	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
	int totalcount=	sqlsession.selectOne("com.neusoft.entity.Address.findTotalCount",userid);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Address> list=sqlsession.selectList("com.neusoft.entity.Address.findAddressByPage", map);
		PageModel<Address> pagemodel=new PageModel<Address>();
		pagemodel.setTotalpage(totalcount%pageSize==0?totalcount/pageSize:totalcount/pageSize+1);
		pagemodel.setData(list);
		return pagemodel;
		
		
	
	}
	@Override
	public Address findAddressByid(Integer id,Integer userid) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("id", id);
		map.put("userid", userid);
		Address address=sqlsession.selectOne("com.neusoft.entity.Address.findAddressByid", map);
		MyBatisUtils.close(sqlsession);
		return address;
	}

}
