package com.neusoft.entity.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.neusoft.consts.OrderStatusEnum;
import com.neusoft.consts.PaymentTypeEnum;
import com.neusoft.entity.Address;
import com.neusoft.entity.User;
import com.neusoft.entity.UserOrder;

public class UserOrderVo {
	private int id;
	private long  order_no;
	private int user_id;
	private User user;
	private Address address;
	private int shipping_id;
	private String payment;
	private String payment_type;
	private int postage;
	private String status;
	private int payment_time;
	private int send_time;
	private String end_time;
	private String close_time;
	private String create_time;//yyyy-MM-dd
 private String  update_time;


 public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Address getAddress() {
	return address;
}


public void setAddress(Address address) {
	this.address = address;
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


public int getShipping_id() {
	return shipping_id;
}


public void setShipping_id(int shipping_id) {
	this.shipping_id = shipping_id;
}


public String getPayment() {
	return payment;
}


public void setPayment(String payment) {
	this.payment = payment;
}


public String getPayment_type() {
	return payment_type;
}


public void setPayment_type(String payment_type) {
	this.payment_type = payment_type;
}


public int getPostage() {
	return postage;
}


public void setPostage(int postage) {
	this.postage = postage;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public int getPayment_time() {
	return payment_time;
}


public void setPayment_time(int payment_time) {
	this.payment_time = payment_time;
}


public int getSend_time() {
	return send_time;
}


public void setSend_time(int send_time) {
	this.send_time = send_time;
}


public String getEnd_time() {
	return end_time;
}


public void setEnd_time(String end_time) {
	this.end_time = end_time;
}


public String getClose_time() {
	return close_time;
}


public void setClose_time(String close_time) {
	this.close_time = close_time;
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


/**
  * 将UserOrder转化为UserOrderVo
  * */
	public UserOrderVo convertUserOrderToOrderVo(UserOrder order) {
		
		this.id=order.getId();
		this.order_no=order.getOrder_no();
		this.payment=order.getPayment().toString();
		Integer paymenttype=order.getPayment_type();
		if(paymenttype==PaymentTypeEnum.ONLINE.getType()) {
			this.payment_type="在线支付";
		}else if(paymenttype==PaymentTypeEnum.ONLINE.getType()) {
			this.payment_type="货到付款";
		}
		this.postage=order.getPostage();
		Integer status=order.getStatus();
		if(status==OrderStatusEnum.PAY.getStatus()) {
            this.status="已付款";

			
		}else if(status==OrderStatusEnum.CANCLE.getStatus()) {
			 this.status="已取消";
		}else if(status==OrderStatusEnum.UNPAY.getStatus()) {
			 this.status="未付款";
		}else if(status==OrderStatusEnum.SEND.getStatus()) {
			 this.status="已发货";
		}else if(status==OrderStatusEnum.SUCCESS.getStatus()) {
			 this.status="交易成功";
		}else if(status==OrderStatusEnum.CLOSE.getStatus()) {
			 this.status="交易关闭";
		}
		Date create_time=order.getCreate_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.create_time=format.format(create_time.getTime());
		this.update_time=format.format(order.getUpdate_time().getTime());
	this.user=order.getUser();
	this.address=order.getAddress();
	return this;
	}
	
	
}
