<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>

</style>
<body>
   
<h2>购物车</h2>
<table>
<tr>
<th>id</th>

<th>用户名</th>
<th>产品名称</th>
<th>数量</th>
<th>是否选中</th>
<th>创建时间</th>
<th>更新时间</th>
<th>操作</th>
</tr>
<c:forEach items="${PageModel.data }" var="cart">
			
			<tr >
			
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cart.id}</td>
			
				
				<td>&nbsp;&nbsp;&nbsp;${cart.user.username}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cart.product.name}</td>
		
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cart.quantity}</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cart.checked}</td>
				
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cart.create_time}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cart.update_time}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="cart.do?operation=3&product_id=${cart.product_id}&userid=${user.id} ">删除</a>
					<a href="cart.do?operation=4&quantity=3&productid=${cart.product_id}&userid=${user.id } ">修改</a>
				</td>
				 
			</tr>
			
			</c:forEach>
		</table>
		<span><a href="cart.do?operation=6" target="i">商品 总数</a></span>
		
		<span><iframe   width="30px" height="30px"  name="i"></iframe></span>
<!-- 	<a href="http://localhost:8080/linana/view/order.do?operationtype=1&shipping_id=4" style="position:right">立即下单</a>  -->
		<p><c:forEach var="pageNo" begin="1" end="${PageModel.totalpage }" step="1">
<a href="cart.do?operation=1&pageNo=${pageNo }&pageSize=2&userid=${user.id}">${pageNo }</a>
</c:forEach></p>

</body>
</html>