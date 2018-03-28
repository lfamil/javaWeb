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
table{
width:1000px;
border: solid 1px #B0C4DE;
border-collapse:collapse;
}
a{
text-decoration: none;
}
#one{
width:100px;
background-color:gainsboro;
margin-bottom:10px;
}
</style>
<body>
<div id="one">
<a href="addAddress.do" >添加地址</a>
</div>
<table>
<tr>
<!-- <th>地址id</th> -->
<th>收货人姓名</th>
<th>收货人固定电话</th>
<th>收货人手机号</th>
<th>省份</th>
<th>城市</th>
<th>区（县）</th>
<th>详细地址</th>
<th>邮编</th>
<th>操作</th>

</tr>
<c:forEach items="${PageModel.data }" var="address">
			
			<tr >
			
			<%-- 	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.id}</td> --%>
			
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.receiver_name}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.receiver_phone}</td>
		
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.receiver_mobile}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.receiver_province }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.receiver_city }</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.receiver_district}</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.receiver_address }</td>	
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.receiver_zip}</td>
				
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="DeleteAddress.do?id=${address.id}&userid=${address.user_id}">删除</a>
					<a href="UpdateAddress.do?id=${address.id}&userid=${address.user_id}">修改</a>
				</td>
				
			</tr>
			
			</c:forEach>
		</table>
		<c:forEach var="pageNo" begin="1" end="${PageModel.totalpage }" step="1">
<a href="AddressPage.do?pageNo=${pageNo }">${pageNo }</a>
</c:forEach>



</body>
</html>