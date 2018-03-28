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
<form action="${initParam.hostname }/linana/updateProduct.do"   method="post">
<table>
<tr>
<td>商品编号</td>
<td>
<input type="text" name="id" value="${product.id }" readonly/>
</td>
</tr>
<tr>
<td>所属类别</td>
<td>
<select name="category_name">
<c:forEach items="${category }" var="c">
<option value="${c.name }">${c.name}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>
商品名称
</td>
<td>
<input type="text" name="name" value="${product.name }"/>
</td>
</tr>
<tr>
<td>
商品副标题
</td>
<td>
<input type="text" name="subtitle" value="${product.subtitle}"/>
</td>
</tr>
<tr>
<td>商品主图</td>
<td><input type="text" name="main_image" value="${product.main_image }"/></td>
</tr>
<tr>
<td>商品子图</td>
<td>
<input type="text" name="sub_images" value="${product.sub_images }"/>
</td>
</tr>
<tr>
<td>商品详情</td>
<td><input type="text" name="detail" value="${product.detail }" ></td>
</tr>
<tr>
<td>价格</td>
<td><input type="text" name="price" value="${product.price }"></td>
</tr>
<tr>
<td>库存数量</td>
<td><input type="number" name="stock" value="${product.stock }" /></td>
</tr>
<tr>
<td>商品状态</td>
<td><select name="status">
<option>上架</option>
<option>下架</option>
</select></td>
</tr>


<tr>
   <td colspan="2"><input type="submit"  value="更新商品信息"/></td>
</tr>
</table>
</form>
</body>
</html>