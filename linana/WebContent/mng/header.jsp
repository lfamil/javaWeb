<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	*{
				margin-left: 10px;
			}
			#one{
				position: fixed;
				height:10%;
border-bottom: solid 1px lightsteelblue;}
#one>ul{
	margin-left:80px;
	display: inline-flex;
	flex-direction: row;
 justify-content: center;
	}
	#one li{
		display: inline-block;		
list-style:none;
width:100px;
	flex-grow: 1;
}
 a{
	text-decoration: none;
}
#two{
	position: fixed;
	top:12%;
width:15%;
height:700px;
border-right:solid 1px lightsteelblue;
}
#three{
	width:80%;
left:17%;
position:fixed;
top:80px;

}
#subth{
	height: 30px;
	background: lightsteelblue;
	margin: 5px;
	width:80%;
}
</style>
</head>
<body>
<div id="one">
<span style="font-size:20px ">欢迎${user.username }登录宜佳超市管理系统</span>
<span><a href="${initParam.hostname }/linana/logout">退出登录</a></span>
<ul>
<li ><a href="#">商品</a></li>
<li><a href="${initParam.hostname }/linana/view/order.do?operationtype=2&pageNo=1&pageSize=2" target="show">订单</a></li>
<li><a href="huiyuan.html" target="_parent">会员</a></li>
<li>营销</li> 
<li>统计</li>
<li>系统</li>

<li>
<form action="${initParam.hostname }/linana/update.do"   method="post">
<a href="${initParam.hostname }/linana/update.do?id=${user.id }" target="_parent">账号管理</a>
<a href="${initParam.hostname }/linana/AddressPage.do?pageNo=1" target="show">地址管理</a>
</form>
</li>
</ul>
</div>
<div id="two">
<ul>
<li><a href="${initParam.hostname }/linana/page.do?pageNo=1" target="show">商品列表</a></li>
<li><a href="${initParam.hostname }/linana/CatePage.do?pageNo=1" target="show">商品分类</a></li>
<li><a href="#" target="show">商品品牌</a></li>
<li><a href="#" target="show">商品类型</a></li>
</ul>
</div>
<div id="three">
<!-- <div id="subth">
	你的位置：商品管理
	
</div> -->
<iframe src="#" width="1000px" height="700px" frameborder="0" name="show"></iframe>
</div>
</body>
</html>