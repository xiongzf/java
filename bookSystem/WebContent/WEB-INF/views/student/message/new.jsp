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
	<jsp:include page="../../include/sNavbar.jsp">
		<jsp:param value="message" name="menu"/>
	</jsp:include>
	<div class="container">
		<form action="/student/new" method="post">
			<label>内容</label>
			<textarea name="content" rows="5" class="span4"></textarea>
			<div class="formactions">
				<button class="btn btn-primary">发布</button>
			</div>
		</form>
	</div>
</body>
</html>