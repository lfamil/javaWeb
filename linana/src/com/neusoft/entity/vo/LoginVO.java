package com.neusoft.entity.vo;

import com.neusoft.entity.User;

/**
 * 登录后将登录信息传到前端
 * */
public class LoginVO {
/**
 * 1:成功
 * 0：失败
 * */
	public static final int LOGIN_SUCC=1;
	public static final int LOGIN_FAIL=0;
	private int errno;
	private String message;
	private User user;
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "LoginVO [errno=" + errno + ", message=" + message + ", user=" + user + "]";
	}
	
}
