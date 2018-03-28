<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
a{
text-decoration:none;
}
table{
	
				margin-top: 10px;
				border: solid 1px #B0C4DE;
				border-collapse:collapse;
			}
			tr{
			border:solid 1px blue;
			}
</style>
</head>
<body>
<h2>订单</h2>
<table style="width:950px">
<tr>
<th>订单编号</th>
<th>下单用户</th>
<th>地址</th>
<th>订单总价</th>
<th>支付方式</th>
<th>邮费</th>
<th>订单状态</th>
<th>创建时间</th>
<th>更新时间</th>
<th>更改订单状态</th> 
</tr>
<c:forEach  items="${Pagemodel.data }" var="order">
<tr>
<td><a href="order.do?operationtype=3&orderno=${order.order_no }">${order.order_no }</a></td>
<td>&nbsp;&nbsp;&nbsp;${order.user.username }</td>
<td>${order.address.receiver_province }</td>
<td>${order.payment }</td>
<td>${order.payment_type }</td>
<td>${order. postage}</td>
<td>${order.status }</td>
<td>${order.create_time }</td>
<td>${order.update_time}</td>
<td>
 <a href="order.do?operationtype=4&orderno=${order.order_no }&status=20">已付款</a> 
 <a href="order.do?operationtype=4&orderno=${order.order_no }&status=0">已取消</a> 
 <a href="order.do?operationtype=4&orderno=${order.order_no }&status=10">未付款</a> 
 <a href="order.do?operationtype=4&orderno=${order.order_no }&status=40">已发货</a> 
<a href="order.do?operationtype=4&orderno=${order.order_no }&status=50">交易成功</a> 
<a href="order.do?operationtype=4&orderno=${order.order_no }&status=60">交易关闭</a> 
</td>

</tr>


</c:forEach>

</table>

<c:forEach var="pageNo" begin="1" end="${Pagemodel.totalpage }" step="1">
<a href="order.do?operationtype=2&pageNo=${pageNo }&pageSize=2">${pageNo }</a>
</c:forEach>
</body>
</html>