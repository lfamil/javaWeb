package com.neusoft.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
private int id;
private String category_name;
private String name;
private String subtitle;
private String main_image;
private String sub_images;
private String detail;
private BigDecimal price;
private int stock;
private String status;
private Date create_time;
private Date update_time;
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(int id, String category_name, String name, String subtitle, String main_image, String sub_images,
		String detail, BigDecimal price, int stock, String status, Date create_time, Date update_time) {
	super();
	this.id = id;
	this.category_name = category_name;
	this.name = name;
	this.subtitle = subtitle;
	this.main_image = main_image;
	this.sub_images = sub_images;
	this.detail = detail;
	this.price = price;
	this.stock = stock;
	this.status = status;
	this.create_time = create_time;
	this.update_time = update_time;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCategory_name() {
	return category_name;
}
public void setCategory_name(String category_name) {
	this.category_name = category_name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSubtitle() {
	return subtitle;
}
public void setSubtitle(String subtitle) {
	this.subtitle = subtitle;
}
public String getMain_image() {
	return main_image;
}
public void setMain_image(String main_image) {
	this.main_image = main_image;
}
public String getSub_images() {
	return sub_images;
}
public void setSub_images(String sub_images) {
	this.sub_images = sub_images;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
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
	return "Product [id=" + id + ", category_name=" + category_name + ", name=" + name + ", subtitle=" + subtitle
			+ ", main_image=" + main_image + ", sub_images=" + sub_images + ", detail=" + detail + ", price=" + price
			+ ", stock=" + stock + ", status=" + status + ", create_time=" + create_time + ", update_time="
			+ update_time + "]";
}

}