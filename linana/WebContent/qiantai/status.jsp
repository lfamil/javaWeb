<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/linana/view/order.do?operationtype=4&orderno=${order.order_no }&status=${order.status}" method="get">
<select name="status">
<option value="40">已发货</option>
<option value="0">已取消</option>
<option value="10">未付款</option>
<option value="20">已付款</option>
<option value="50">交易成功</option>
<option value="60">交易失败</option>
</select>
<a href="/linana/view/order.do?operationtype=4&orderno=${order.order_no }&status=${order.status}">更改</a>
</form>
</body>
</html>