package com.neusoft.consts;
/**
 * 订单状态枚举类型
 * */
public enum OrderStatusEnum {
	
	CANCLE(0,"已取消"),
	
	UNPAY(10,"未付款"),
	PAY(20,"已付款"),
	SEND(40,"已发货"),
	SUCCESS(50,"交易成功"),
	CLOSE(60,"交易关闭");
	
	private int status;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private OrderStatusEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
}
