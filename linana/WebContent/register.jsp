<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${initParam.hostname }/linana/Register.do" method="post">
<table>

<tr>
<td>
姓名
</td>
<td>
<input type="text" name="username"/>
</td>
</tr>
<tr>
<td>密码</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td>邮箱</td>
<td><input type="email" name="email"/></td>
</tr>
<tr>
<td>手机号</td>
<td><input type="text" name="phone"></td>
</tr>
<tr>
<td>密保问题</td>
<td><input type="text" name="question"></td>
</tr>
<tr>
<td>找回密码答案</td>
<td><input type="text" name="answer"/></td>
</tr>
<tr>
<td>角色</td>
<td><input type="text" name="role"></td>
</tr>


<tr>
   <td colspan="2"><input type="submit"  value="注册"/></td>
</tr>
</table>
</form>
</body>
</html>