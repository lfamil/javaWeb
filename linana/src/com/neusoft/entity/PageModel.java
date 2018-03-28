package com.neusoft.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8970067410776328150L;
	private List<T> data;
	private int totalpage;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public PageModel(List<T> data) {
		super();
		this.data = data;
	}
	public PageModel() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	public String toString() {
		return "PageModel [data=" + data + ", totalpage=" + totalpage + "]";
	}
	
	

}
