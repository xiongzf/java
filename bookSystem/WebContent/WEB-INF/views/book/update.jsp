<%@page import="cn.xzf.entityAll.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<form action="/book/update?id=${book.id }" method="post">
			<legend>修改书籍</legend>
			<label>书籍名称</label>
			<input type="text" name="bookname" value="${book.bookname}"/>
			<label>作者</label>
			<input type="text" name="author" value="${book.author }"/>
			<label>出版社</label>
			<input type="text" name="publish" value="${book.publish}"/>
			<label>isbn</label>
			<input type="text" name="isbn" value="${book.isbn }"/>
			<label>总数量</label>
			<input type="text" name="total" value="${book.total }"/>
			<label>现有数量</label>
			<input type="text" name="nownum" value="${book.nownum }"/>
			<div>
				<button class="btn btn-success form-action">修改</button>
			</div>
			
		</form>
	</div>
</body>
</html>