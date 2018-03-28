package com.neusoft.entity.vo;

public class CartCheckedVO {
private Integer product_id;
private Integer checked;
private Integer errno;//错误码errno   1:成功   0:出错
private String emessage;//存放错误信息
public static final Integer ERRNO_SUCESS=1;
public static final Integer ERRNO_FAIL=0;

public CartCheckedVO() {
	super();
	// TODO Auto-generated constructor stub
}

public String getEmessage() {
	return emessage;
}
public void setEmessage(String emessage) {
	this.emessage = emessage;
}
public Integer getErrno() {
	return errno;
}
public void setErrno(Integer errno) {
	this.errno = errno;
}
public Integer getProduct_id() {
	return product_id;
}
public void setProduct_id(Integer product_id) {
	this.product_id = product_id;
}
public Integer getChecked() {
	return checked;
}
public void setChecked(Integer checked) {
	this.checked = checked;
}
@Override
public String toString() {
	return "CartCheckedVO [product_id=" + product_id + ", checked=" + checked + ", errno=" + errno + ", emessage="
			+ emessage + "]";
}


}
