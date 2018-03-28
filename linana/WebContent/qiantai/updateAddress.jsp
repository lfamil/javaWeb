<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${initParam.hostname }/linana/UpdateAddress.do" method="post">
<table>

<tr><td>地址id</td>
<td><input type="text" name="id" value="${address.id }" readonly></td>
</tr>

<tr><td>收货人姓名</td>
<td><input type="text" name="receiver_name" value="${address.receiver_name }"/></td>
</tr>
<tr><td>收货人固定电话</td>
<td>
<input type="text" name="receiver_phone" value="${address.receiver_phone}">
</td>
</tr>
<tr><td>收货人手机号</td>
<td><input type="text" name="receiver_mobile" value="${address.receiver_mobile }"/></td>
</tr>
<tr><td>省份</td>
<td><input type="text" name="receiver_province" value="${address.receiver_province }"/></td>
</tr>
<tr>
<td>城市</td>
<td>
<input type="text" name="receiver_city"  value="${address.receiver_city }">
</td>
</tr>
<tr><td>区（县）</td>
<td><input type="text" name="receiver_district"  value="${address.receiver_district }"></td>
</tr>
<tr><td>详细地址</td>
<td><input type="text" name="receiver_address"  value="${address.receiver_address }"></td>
</tr>
<tr><td>邮编</td>
<td><input type="text" name="receiver_zip"  value="${address.receiver_zip }"></td>
</tr>


</table>
<input type="submit"  value="修改地址">
</form>
</body>
</html>