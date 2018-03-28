<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table{
width:600px;
				margin-top: 10px;
				border: solid 1px gray;
				border-collapse:collapse; 
}
tr{
			border:solid 1px gray;
			
			}
 td{
border:solid 1px gray;
background:lightsteelblue;
}

</style>
</head>
<body>
<form action="${initParam.hostname }/linana/addProduct.do" method="post">
<table>

<tr><td>商品名称</td>
<td><input type="text" name="name"></td>
</tr>

<tr><td>货号</td>
<td><input type="text" name="id"/></td>
</tr>
<tr><td>所属分类</td>
<td><select name="category_name">
<c:forEach items="${category }" var="c">
<option value="${c.name }">${c.name}</option>
</c:forEach>
</select>
</td>
</tr>
<tr><td>上传图片</td>
<td><input type="text" name="main_image"/></td>
</tr>
<tr><td>商品价格</td>
<td><input type="text" name="price"/></td>
</tr>
<tr>
<td>商品状态</td>
<td><select name="status">
<option>上架</option>
<option>下架</option>
</select>

</td>
</tr>
<tr><td>库存</td>
<td><input type="number" name="stock"/></td>
</tr>
<tr><td>商品详情</td>
<td><input type="text" name="detail"></td>
</tr>



</table>
<input type="submit"  value="添加新商品">
</form>
</body>
</html>