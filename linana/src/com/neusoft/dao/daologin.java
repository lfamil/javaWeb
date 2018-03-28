package com.neusoft.dao;

import java.util.List;

import com.neusoft.entity.PageModel;
import com.neusoft.entity.User;
import com.neusoft.exception.MyException;

public interface daologin {
	public int  checkUserName(String username) throws MyException;
	
	public User findUserByUsernameAndPassword(String username, String password) throws MyException;
	
	public List<User> findAllUser();
	public int deleteUserByid(Integer id);
	public int addUser(User user);
	public User findUserbyid(Integer id);
	public int updateUser(User user);
	

	/**
	 * �����û�token
	 * */
	
	int updateTokenByUserId(Integer id,String token);
	/**
	 * �����û�token ��ѯ�û���Ϣ
	 * @param token
	 * @return user
	 * */
	 User findUserByToken(String token) throws MyException;
	 /**
	  * ��ҳ��ѯ
	  * */
	 PageModel<User> findUserByPage(Integer pageNo,Integer pageSize);
	 /**
	  * ���������û���Ϣ
	  * */
	 int addBatchUser(List<User> users) throws MyException;
	 /**
	  * ����ids��ѯָ�����û���Ϣ
	  * */
	List<User> findUserByforeach(List<Integer> ids) throws MyException;
}
