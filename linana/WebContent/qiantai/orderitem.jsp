<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<h3>订单详情</h3>
<table>
<tr>
<th>订单编号</th>
<th>用户名</th>
<th>商品名称</th>
<th>商品图片 </th>
<th>实际价格</th>
<th>数量</th>
<th>总价</th>
<th>创建时间</th>
</tr>
<c:forEach items="${list }" var="oritem">
<tr>
<td>${oritem.order_no }</td>
<td>${oritem.user.username}</td>
<td><a href="order.do?operationtype=5&product_name=${ oritem.product_name}">${oritem.product_name }</a></td>
<td>${oritem.product_image }</td>
<td>${oritem.current_unit_price }</td>
<td>${oritem.quantity}</td>
<td>${oritem.total_price}</td>
<td>${oritem.create_time}</td>
</tr>
</c:forEach>
</table>

</body>
</html>