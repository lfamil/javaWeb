<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
<style>
.container{
width:300px;
height:400px;
position:relative;

}
.form-group{
color:white;
}
h1{
margin:100px 150px;
}
</style>
</head>
<body style="background-image:url(img/mnglogin.jpg)">
<h1 style="color:white">宜佳超市后台管理系统</h1>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="User/login" method="post">
				<div class="form-group">
					 <label for="exampleInputEmail1">用户名</label><input class="form-control" name="name" id="username" type="text" />
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">密码</label><input class="form-control" name="password" id="password" type="password" />
				</div>
				
				
				 <button type="submit" class="btn btn-default">登录</button>
				 <a href="register.jsp">注册</a>
			</form>
		</div>
	</div>
</div>

</body>
</html>