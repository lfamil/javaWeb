package com.neusoft.entity.vo;

import com.neusoft.entity.PageModel;

public class CartVOl {
	public static final int CART_SUCC=1;
	public static final int CART_UNLOGIN=0;
	private int errno;
	private String message;
	private PageModel<CartVO> pagemodel;
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	public PageModel<CartVO> getPagemodel() {
		return pagemodel;
	}
	public void setPagemodel(PageModel<CartVO> pagemodel) {
		this.pagemodel = pagemodel;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
