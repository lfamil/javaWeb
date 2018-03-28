<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>订单编号</th>

 <th>商品名称</th>
<th>商品主图</th>
<th>单价</th>
<th>数量</th>

<th>实付金额</th>
<th>创建时间</th>

</tr>
<c:forEach items="${orderitems }" var="items">
<tr>
<td>${items.order_no }</td>

<td>&nbsp;&nbsp;&nbsp;<a href="order.do?operationtype=5&product_name=${ oritem.product_name}">${items.product_name }</a></td> 
<td>${items.product_image}</td>
<td>${items.current_unit_price}</td>
<td>${items.quantity}</td>
<td>${items.total_price}</td>

<td>${order.create_time }</td>




</tr>
</c:forEach>



</table>
</body>
</html>