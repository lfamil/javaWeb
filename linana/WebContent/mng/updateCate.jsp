<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:blue">修改分类</h2>
<form action="${initParam.hostname }/linana/CateUpdate.do" method="post">
<table>
<tr>
<td>ID</td>
<td><input type="text" name="id" value="${category.id }" readonly></td>
</tr>
<tr><td>分类名称</td>
<td><input type="text" name="name" value="${category.name }"></td>
</tr>
<tr><td>上级分类</td>
<td><select name="parent_id">
<c:forEach items="${cate }" var="ca">
<option value="${ca.id }"> ${ca.name}</option>
</c:forEach>
</select></td>
</tr>
<tr>
<td>类别状态</td>
<td><select name="status">
<option>1</option>
<option>2</option>
</select></td>
</tr>
<tr>
<td>优先顺序</td>
<td><input type="text" name="sort_order" value="${category.sort_order }"></td>
</tr>
<tr>
<td>创建时间</td>
<td><input type="date" name="create_time" value="${category.create_time }"></td>
</tr>
</table>
<div style="float:right">
<input type="submit" value="更新"/>
</div>
</form>
</body>
</html>