package com.neusoft.service;

import java.util.List;

import com.neusoft.entity.User;

public interface Servicelogin {
	public User login(String username,String password);
	public List<User> findUser();
	 public int deleteUserByid(Integer id);
	 public int addUser(User user);
	 public User findUserbyid(Integer id);
		public int updateUser(User user);
	
	/**
	 * 根据id更新用户的token信息
	 * @return int>0  更新成功
	 * */
		public int updateTokenByUserId(Integer id, String token);
/**
 * 根据token查询用户信息
 * */
		public User findUserByToken(String token);
}
