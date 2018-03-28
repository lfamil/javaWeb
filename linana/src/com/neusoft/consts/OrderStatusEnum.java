package com.neusoft.consts;
/**
 * ����״̬ö������
 * */
public enum OrderStatusEnum {
	
	CANCLE(0,"��ȡ��"),
	
	UNPAY(10,"δ����"),
	PAY(20,"�Ѹ���"),
	SEND(40,"�ѷ���"),
	SUCCESS(50,"���׳ɹ�"),
	CLOSE(60,"���׹ر�");
	
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
