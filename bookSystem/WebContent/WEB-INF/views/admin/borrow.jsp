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
	<div class="container">
		<div>
			<table class="table">
			<thead>
				<tr>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>ISBN</th>
				</tr>
			</thead>
			<tbody>
						<tr>
							<td>${book.bookname }</td>
							<td>${book.author }</td>
							<td>${book.publish }</td>
							<td>${book.isbn }</td>
						</tr>
			</tbody>
		</table>
		</div>
		<form action="/book/borrow?bid=${book.id }" method="post">
			<label>借书卡号</label>
			<input type="text" name="cid"/>
			<div class="form-action">
				<button class="btn btn-primary">借阅</button>
			</div>
		</form>
	</div>
</body>
</html>