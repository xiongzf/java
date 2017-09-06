<%@page import="cn.xzf.entityAll.Student"%>
<%@page import="cn.xzf.entityAll.Book"%>
<%@page import="java.util.List"%>
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
	<jsp:include page="../../include/sNavbar.jsp">
		<jsp:param value="search" name="menu"/>
	</jsp:include>
	
	<div class="container">
		<form action="/student/book/search" method="post" class="form-search">
			<input type="text" class="span4" name="txt"/>
			<button class="btn btn-primary form-action">搜索</button>
		</form>
		<div>
			<table class="table">
			<thead>
				<tr>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>ISBN</th>
				<th>总数量</th>
				<th>现存数量</th>
				<th>借阅</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty booklist }">
					<tr> 
						<td colspan="7">对不起，没有匹配到相关书籍</td>
					</tr>
				</c:if>
				<c:forEach items="${booklist }" var="book">
					<tr>
						<td>${book.bookname}</td>
						<td>${book.author }</td>
						<td>${book.publish}</td>
						<td>${book.isbn }</td>
						<td>${book.total }</td>
						<td>${book.nownum }</td>
						<td>
							<c:if test="${book.nownum>0 }">
								<a href="/student/borrow?id=${book.id }">借阅</a>
							</c:if>
							<c:if test="${book.nownum<=0 }">
								<a href="#">不可借阅</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
				
		</table>
		</div>
	</div>
</body>
</html>