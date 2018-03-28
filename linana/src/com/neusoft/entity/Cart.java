package com.neusoft.entity;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 3930734874028053462L;
private int id;
//private  int user_id;
private User user;
private int product_id;
private Product product;
private int quantity;
private int checked;
private Date create_time;
private Date update_time;

public Cart() {
	super();
	// TODO Auto-generated constructor stub
}

public Cart(int id, User user, int product_id, Product product, int quantity, int checked, Date create_time,
		Date update_time) {
	super();
	this.id = id;
	this.user = user;
	this.product_id = product_id;
	this.product = product;
	this.quantity = quantity;
	this.checked = checked;
	this.create_time = create_time;
	this.update_time = update_time;
	
}



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
public Date getCreate_time() {
	return create_time;
}
public void setCreate_time(Date create_time) {
	this.create_time = create_time;
}
public Date getUpdate_time() {
	return update_time;
}
public void setUpdate_time(Date update_time) {
	this.update_time = update_time;
}

@Override
public String toString() {
	return "Cart [id=" + id + ", user=" + user + ", product_id=" + product_id + ", product=" + product + ", quantity="
			+ quantity + ", checked=" + checked + ", create_time=" + create_time + ", update_time=" + update_time
			+ "]";
}


}
