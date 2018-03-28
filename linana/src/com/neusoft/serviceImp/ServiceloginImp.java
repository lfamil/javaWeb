package com.neusoft.serviceImp;

import java.util.List;

import com.neusoft.dao.daologin;
import com.neusoft.daoImp.UserdaoBatisImpl;
import com.neusoft.entity.User;
import com.neusoft.service.Servicelogin;

public class ServiceloginImp implements Servicelogin {
	daologin dl=new UserdaoBatisImpl();
	public User login(String username,String password) {
		// TODO Auto-generated method stub
		User user=null;
		
		int count=dl.checkUserName(username);
		if(count>0) {
user= dl.findUserByUsernameAndPassword(username,password);
System.out.println(user);
return user;
		 }
		return null;
		
	}

	@Override
	public List<User> findUser() {
		// TODO Auto-generated method stub
	
		return dl.findAllUser();
	}
	 public int deleteUserByid(Integer id) {
		
		 return dl.deleteUserByid(id);
	 }

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		
		return dl.addUser(user);
	}

	@Override
	public User findUserbyid(Integer id) {
		// TODO Auto-generated method stub
	
		return dl.findUserbyid(id);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
	
		return dl.updateUser(user);
	}

	@Override
	public int updateTokenByUserId(Integer id, String token) {
		// TODO Auto-generated method stub
		
		return dl.updateTokenByUserId(id, token);
	}

	@Override
	public User findUserByToken(String token) {
		// TODO Auto-generated method stub
		return dl.findUserByToken(token);
	}

	
	

}
