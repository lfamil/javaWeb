package com.neusoft.entity.vo;

import com.neusoft.entity.PageModel;

public class Ordervol {
	public static final int ORDER_SUCC=1;
	public static final int ORDER_UNLOGIN=0;
	private int errno;
	private String message;
	private PageModel<UserOrderVo> pagemodel;
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
	public PageModel<UserOrderVo> getPagemodel() {
		return pagemodel;
	}
	public void setPagemodel(PageModel<UserOrderVo> pagemodel) {
		this.pagemodel = pagemodel;
	}

	
}
