package com.neusoft.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.neusoft.dao.daologin;
import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.exception.MyException;
import com.nuesoft.common.MyBatisUtils;

public class UserdaoBatisImpl implements daologin {
	 /**1，读取配置文件
	 2，生成SqlSessionFactory  
	为SqlSession的工厂，用于建立与数据库的会话。
	3，建立SqlSession

	用于执行sql语句
	4，调用MyBatis提供的api
	5，查询MAP配置
	6，返回结果
	7，关闭SqlSession
	*/
	
	@Override
	public int checkUserName(String username) throws MyException {
		// TODO Auto-generated method stub		
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		int result = sqlsession.selectOne("com.neusoft.entity.User.checkUserName", username);
		MyBatisUtils.close(sqlsession);
		return result;
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) throws MyException {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		Object o =sqlsession.selectOne("com.neusoft.entity.User.findUserByUsernameAnaPassword",map);
		
		
		if(o instanceof User) {
		User	user=(User) o;
		sqlsession.commit();
		sqlsession.close();
		return user;
		}
		return null;
		
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		List<User> list=sqlsession.selectList("com.neusoft.entity.User.findAllUser");
		MyBatisUtils.close(sqlsession);
		return list;
		
	}

	@Override
	public int deleteUserByid(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		int result=sqlsession.delete("com.neusoft.entity.User.deleteUserById", id);
		sqlsession.commit();
		return result;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		int result=sqlsession.insert("com.neusoft.entity.User.addUser", user);
		sqlsession.commit();
		return result;
	}

	@Override
	public User findUserbyid(Integer id) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		User user=sqlsession.selectOne("com.neusoft.entity.User.findUserById",id);
		return user;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		int result=sqlsession.update("com.neusoft.entity.User.updateUser", user);
	sqlsession.commit();
		return result;
	}

	@Override
	public int updateTokenByUserId(Integer id, String token) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession(false);
		Map<String,Object> map=new HashMap<String,Object>();
	
		map.put("token", token);
		map.put("userid", id);
		int result=sqlsession.update("com.neusoft.entity.User.updateTokenByUserId", map);
		sqlsession.commit();
		MyBatisUtils.close(sqlsession);
		return result;
	}

	@Override
	public User findUserByToken(String token) throws MyException {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession(true);
	User user=	sqlsession.selectOne("com.neusoft.entity.User.findUserByToken", token);
	MyBatisUtils.close(sqlsession);
		return user;
	}

	@Override
	public PageModel<User> findUserByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
	int totalcount=	sqlsession.selectOne("com.neusoft.entity.User.findTotalCount");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<User> list=sqlsession.selectList("com.neusoft.entity.User.findUserByPage", map);
		PageModel<User> pagemodel=new PageModel<User>();
		pagemodel.setTotalpage(totalcount%pageSize==0?totalcount/pageSize:totalcount/pageSize+1);
		pagemodel.setData(list);
		return pagemodel;
	}

	@Override
	public int addBatchUser(List<User> users) throws MyException {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		int result=sqlsession.insert("com.neusoft.entity.User.addBatchUser", users);
		sqlsession.commit();
		return result;
	}

	@Override
	public List<User> findUserByforeach(List<Integer> ids) throws MyException {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlsessionfactory = MyBatisUtils.getSqlSessionFactory();
		SqlSession sqlsession = sqlsessionfactory.openSession();
		List<User> users=sqlsession.selectList("com.neusoft.entity.User.findUserByforeach", ids);
		return users;
	}

}
