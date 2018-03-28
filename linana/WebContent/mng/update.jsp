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
<form action="${initParam.hostname }/linana/update.do"   method="post">
<table>
<tr>
<td>id</td>
<td>
<input type="text" name="id" value="${user.id }" readonly/>
</td>
</tr>
<tr>
<td>
用户名
</td>
<td>
<input type="text" name="username" value="${user.username }"/>
</td>
</tr>
<tr>
<td>
密码
</td>
<td>
<input type="text" name="password" value="${user.password }"/>
</td>
</tr>
<tr>
<td>邮箱</td>
<td><input type="text" name="email" value="${user.email }"/></td>
</tr>
<tr>
<td>手机号</td>
<td>
<input type="text" name="phone" value="${user.phone }"/>
</td>
</tr>
<tr>
<td>密保问题</td>
<td><input type="text" name="question" value="${user.question }" readonly></td>
</tr>
<tr>
<td>密保答案</td>
<td><input type="text" name="answer" value="${user.answer }"></td>
</tr>
<tr>
<td>角色</td>
<td><input type="text" name="role" value="${user.role }" readonly/></td>
</tr>
<tr>
<td>创建时间</td>
<td><input type="text" name="create_time" value="${user.create_time }" readonly/></td>
</tr>
<tr>
<td>更新时间</td>
<td><input type="text" name="update_time" value="${user.update_time }" readonly/></td>
</tr>
<tr>
   <td colspan="2"><input type="submit"  value="更新用户信息"/></td>
</tr>
</table>
</form>
</body>
</html>