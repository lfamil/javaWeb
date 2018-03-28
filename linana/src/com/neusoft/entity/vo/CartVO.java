package com.neusoft.entity.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.neusoft.entity.Cart;
import com.neusoft.entity.Product;
import com.neusoft.entity.User;

public class CartVO {

	private int id;
	//private  int user_id;
	private User user;
	private int product_id;
	private Product product;
	private int quantity;
	private int checked;
	private String create_time;
	private String update_time;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	public void convertCartToCartVO(Cart cart) {
		this.id=cart.getId();
		this.user=cart.getUser();
		this.product_id=cart.getProduct_id();
		this.product=cart.getProduct();
		this.quantity=cart.getQuantity();
		this.checked=cart.getChecked();
		Date create_time=cart.getCreate_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.create_time=format.format(create_time.getTime());
		this.update_time=format.format(cart.getUpdate_time().getTime());
		
	}
	
}
