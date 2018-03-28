<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${initParam.hostname }/linana/addAddress.do" method="post">
<table>

<!-- <tr><td>地址id</td>
<td><input type="text" name="id"></td>
</tr> -->

<tr><td>收货人姓名</td>
<td><input type="text" name="receiver_name"/></td>
</tr>
<tr><td>收货人固定电话</td>
<td>
<input type="text" name="receiver_phone">
</td>
</tr>
<tr><td>收货人手机号</td>
<td><input type="text" name="receiver_mobile"/></td>
</tr>
<tr><td>省份</td>
<td><input type="text" name="receiver_province"/></td>
</tr>
<tr>
<td>城市</td>
<td>
<input type="text" name="receiver_city">
</td>
</tr>
<tr><td>区（县）</td>
<td><input type="text" name="receiver_district"></td>
</tr>
<tr><td>详细地址</td>
<td><input type="text" name="receiver_address"></td>
</tr>
<tr><td>邮编</td>
<td><input type="text" name="receiver_zip"></td>
</tr>


</table>
<input type="submit"  value="添加新地址">
</form>
</body>
</html>