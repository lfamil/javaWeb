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
	 * 更新用户token
	 * */
	
	int updateTokenByUserId(Integer id,String token);
	/**
	 * 根据用户token 查询用户信息
	 * @param token
	 * @return user
	 * */
	 User findUserByToken(String token) throws MyException;
	 /**
	  * 分页查询
	  * */
	 PageModel<User> findUserByPage(Integer pageNo,Integer pageSize);
	 /**
	  * 批量插入用户信息
	  * */
	 int addBatchUser(List<User> users) throws MyException;
	 /**
	  * 根据ids查询指定的用户信息
	  * */
	List<User> findUserByforeach(List<Integer> ids) throws MyException;
}
