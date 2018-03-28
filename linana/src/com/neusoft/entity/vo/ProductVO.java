package com.neusoft.entity.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.neusoft.entity.Product;

public class ProductVO {
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
	private String create_time;
	private String update_time;
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
	
	public ProductVO convertProductToVo(Product product) {
		this.id=product.getId();
		this.category_name=product.getCategory_name();
		this.name=product.getName();
		this.subtitle=product.getSubtitle();
		this.main_image=product.getMain_image();
		this.sub_images=product.getSub_images();
		this.detail=product.getDetail();
		this.price=product.getPrice();
		this.stock=product.getStock();
		this.status=product.getStatus();
		Date create_time=product.getCreate_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.create_time=format.format(create_time.getTime());
		this.update_time=format.format(product.getUpdate_time().getTime());
		return this;
	}
}
