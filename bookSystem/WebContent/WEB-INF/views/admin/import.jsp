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
		<jsp:param value="book" name="menu"/>
	</jsp:include>
	<div class="container">
		<div class="page-header">
			<h3>1.下载模板</h3>
			<a href="/admin/download/temp">点击下载数据模板</a>
		</div>
		<div class="page-header">
			<h3>2.上传Excel数据</h3>
		</div>
		<form action="/book/import" method="post" enctype="multipart/form-data">
			<input type="file"name="dataFile">
			<div class="form-action">
				<button class="btn btn-success">上传</button>
			</div>
		</form>
	</div>
</body>
</html>