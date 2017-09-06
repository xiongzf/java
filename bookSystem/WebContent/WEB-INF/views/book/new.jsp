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
		<form action="/book/new" method="post">
			<legend>添加新书籍</legend>
			<label>书籍名称</label>
			<input type="text" name="bookname"/>
			<label>作者</label>
			<input type="text" name="author"/>
			<label>出版社</label>
			<input type="text" name="publish"/>
			<label>isbn</label>
			<input type="text" name="isbn"/>
			<label>总数量</label>
			<input type="text" name="total"/>
			<div>
				<button class="btn btn-success form-action">添加</button>
			</div>
			
		</form>
	</div>
</body>
</html>