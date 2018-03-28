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
	 * ����id�����û���token��Ϣ
	 * @return int>0  ���³ɹ�
	 * */
		public int updateTokenByUserId(Integer id, String token);
/**
 * ����token��ѯ�û���Ϣ
 * */
		public User findUserByToken(String token);
}
