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
<table>
<tr>
<th>
用户id
</th>
<th> 姓名</th>
<th>邮箱</th>
<th>手机号</th>
<th>密保问题</th>
<th>密保答案</th>
<th>角色</th>
<th>创建时间</th>

<th>更新时间</th>
<th>用户操作</th>

</tr>
<c:forEach items="${users }" var="user">
<tr>
<td>${user.id}</td>
<td>${user.username}</td>
<td>${user.email}</td>
<td>${user.phone}</td>
<td>${user.question}</td>
<td>${user.answer }</td>
<td>${user.role}</td>

<td>${user.create_time}</td>
<td>${user.update_time }</td>
<td><a href="${initParam.hostname }/linana/delete.do?id=${user.id }">删除</a><a href="update.do?id=${user.id}">修改</a>

</td>
</tr>

</c:forEach>
</table>
</body>
</html>