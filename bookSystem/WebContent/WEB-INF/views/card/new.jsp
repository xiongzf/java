<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/all.css" />
</head>
<body>
	<jsp:include page="../include/aNavbar.jsp">
		<jsp:param value="card" name="menu"/>
	</jsp:include>
	<div class="container">
		<form action="/card/new" method="post">
			<legend>添加新借书证</legend>
			<label>姓名</label>
			<input type="text" name="stuname"/>
			<label>卡号</label>
			<input type="text" name="cardnum"/>
			<label>电话</label>
			<input type="text" name="tel"/>
			<label>地址</label>
			<input type="text" name="address"/>
			<div>
				<button class="btn btn-success form-action">添加</button>
			</div>
			
		</form>
	</div>
</body>
</html>