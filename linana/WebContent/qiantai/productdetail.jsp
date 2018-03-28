<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
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
<h3>商品详情</h3>
<table >
			<tr>
		
			<th>id</th>
		<th>名称</th>
			<th>商品主图</th>
			<th>商品详情</th>
			<th>单价</th>
		<th>创建时间</th>
		<th>更新时间</th>
			</tr>
		
			<tr >
				
				
				<td>${product.id }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.name}</td>
		
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.main_image}</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.detail }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.price}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.create_time}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.update_time}</td>
				</tr>
				</table>
</body>
</html>