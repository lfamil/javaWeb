package com.neusoft.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
private int id;
private long order_no;
private int user_id;
private User user;
private Product product;
private int product_id;
private String product_name;
private String product_image;
private BigDecimal current_unit_price;
private int quantity;
private BigDecimal total_price;
private Date create_time;
private Date update_time;
public OrderItem() {
	super();
	// TODO Auto-generated constructor stub
}

public OrderItem( long order_no) {
	super();
	
	this.order_no = order_no;
	
}

public OrderItem(int id, long order_no, int user_id, int product_id, String product_name, String product_image,
		BigDecimal current_unit_price, int quantity, BigDecimal total_price, Date create_time, Date update_time) {
	super();
	this.id = id;
	this.order_no = order_no;
	this.user_id = user_id;
	this.product_id = product_id;
	this.product_name = product_name;
	this.product_image = product_image;
	this.current_unit_price = current_unit_price;
	this.quantity = quantity;
	this.total_price = total_price;
	this.create_time = create_time;
	this.update_time = update_time;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public long getOrder_no() {
	return order_no;
}
public void setOrder_no(long order_no) {
	this.order_no = order_no;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public int getProduct_id() {
	return product_id;
}
public void setProduct_id(int product_id) {
	this.product_id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_image() {
	return product_image;
}
public void setProduct_image(String product_image) {
	this.product_image = product_image;
}
public BigDecimal getCurrent_unit_price() {
	return current_unit_price;
}
public void setCurrent_unit_price(BigDecimal current_unit_price) {
	this.current_unit_price = current_unit_price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public BigDecimal getTotal_price() {
	return total_price;
}
public void setTotal_price(BigDecimal total_price) {
	this.total_price = total_price;
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
	return "OrderItem [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", product_id=" + product_id
			+ ", product_name=" + product_name + ", product_image=" + product_image + ", current_unit_price="
			+ current_unit_price + ", quantity=" + quantity + ", total_price=" + total_price + ", create_time="
			+ create_time + ", update_time=" + update_time + "]";
}

}
