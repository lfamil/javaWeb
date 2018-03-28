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
			
			#one a{
				text-decoration: none;
				display: inline-block;
				width:60px;
			height:23px;
			border-radius: 8px;
			/**-ms-兼容IE内核浏览器*/
			-ms-border-radius:8px;
			/**-moz-兼容火狐内核浏览器*/
			-moz-border-radius: 8px;
			/**-webkit-兼容谷歌内核浏览器*/
			-webkit-border-radius: 8px;
			/**-o-兼容opera内核浏览器*/
			-o-border-radius:8px;
			background:#B0C4DE;
			text-align: center;
			font-size: 14px;
			color: grey;
			}
			table{
			width:700px;
				margin-top: 10px;
				border: solid 1px #B0C4DE;
				border-collapse:collapse;
			}
			tr{
			border:dashed 1px blue;
			}
		</style>
<body>

<div id="one">
	
			<input type="search" value="商品编号/名称" style="margin-left: 200px;height: 30px;width: 200px;"/>
		<a href="#" >搜索</a>
		</div>
		<table >
			<tr>
			
			<th>id</th>
		<th>名称</th>
			<th>商品主图</th>
			<th>商品详情</th>
			<th>单价</th>
			<th>操作</th>
			</tr>
			<c:forEach items="${product}" var="product">
			
			<tr >
			
				
				<td>&nbsp;&nbsp;&nbsp;${product.id }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.name}</td>
		
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.main_image}</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.detail }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.price}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="view/cart.do?operation=2&product_id=${product.id}&quantity=10 ">加入购物车</a>
					
				</td>
				
			</tr>
			
			</c:forEach>
		</table>
		

</body>
</html>	
			
			