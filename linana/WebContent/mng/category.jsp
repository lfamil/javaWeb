<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			width:600px;
				margin-top: 10px;
				border: solid 1px #B0C4DE;
				border-collapse:collapse;
			}
			tr{
			border:dashed 1px blue;
			}
			</style>
</head>
<body>
<div id="one">
		<a href="${initParam.hostname }/linana/CateAdd.do" >添加</a>
		<a href="${initParam.hostname }/linana/CateDelete.do">删除</a>
		<a href="#">回收站</a>
		</div>
			<table >
			<tr>
			
			<th>编号</th>
			<th>上级编号</th>
			<th>类名</th>
			<th>状态</th>
			<th>排序</th>
			<th>创建时间</th>
			
			<th>操作</th>
			</tr>
			<c:forEach items="${PageModel.data }" var="category">
			
			<tr >
				
				<td>&nbsp;&nbsp;&nbsp;&nbsp;${category.id}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;${category.parent_id }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;${category.name}</td>
				
				<td>&nbsp;&nbsp;&nbsp;&nbsp;${category.status}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;${category.sort_order}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;${category.create_time }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="CateDelete.do?id=${category.id}">删除</a>
					<a href="CateUpdate.do?id=${category.id}">修改</a>
				</td>
				
			</tr>
			
			</c:forEach>
		</table>
		<c:forEach var="pageNo" begin="1" end="${PageModel.totalpage }" step="1">
<a href="CatePage.do?pageNo=${pageNo }">${pageNo }</a>
</c:forEach>
		
</body>
</html>