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
		<a href="${initParam.hostname }/linana/addProduct.do" >添加</a>
		<a href="${initParam.hostname }/linana/deleteProduct.do">删除</a>
		<a href="#">回收站</a>
			<input type="search" value="商品编号/名称" style="margin-left: 200px;height: 30px;width: 200px;"/>
		<a href="product.html" >搜索</a>
		</div>
		<table >
			<tr>
			<td><input type="radio"></td>
			<th>编号</th>
			<th>所属类别</th>
			<th>名称</th>
			
			<th>库存</th>
			<th>状态</th>
			<th>创建时间</th>
			<th>操作</th>
			</tr>
			<c:forEach items="${PageModel.data }" var="product">
			
			<tr >
				<td><input type="radio"></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.id}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.category_name}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.name}</td>
		
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.stock}</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.status }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${product.create_time}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteProduct.do?id=${product.id}">删除</a>
					<a href="updateProduct.do?id=${product.id}">修改</a>
				</td>
				
			</tr>
			
			</c:forEach>
		</table>
		<c:forEach var="pageNo" begin="1" end="${PageModel.totalpage }" step="1">
<a href="page.do?pageNo=${pageNo }">${pageNo }</a>
</c:forEach>
</body>
</html>