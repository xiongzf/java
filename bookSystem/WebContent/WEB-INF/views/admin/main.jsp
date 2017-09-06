<%@page import="cn.xzf.entityAll.Admin"%>
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
	<jsp:include page="../include/aNavbar.jsp">
		<jsp:param value="main" name="menu"/>
	</jsp:include>
	<div class="container">
			
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
				<c:if test="${empty blist }">
					<tr> 
						<td colspan="7">书库还没有图书</td>
					</tr>
				</c:if>
				<c:forEach items="${blist }" var="book">
					<tr>
						<td>${book.bookname}</td>
						<td>${book.author }</td>
						<td>${book.publish}</td>
						<td>${book.isbn }</td>
						<td>${book.total }</td>
						<td>${book.nownum }</td>
						<td>
							<c:if test="${book.nownum>0 }">
								<a href="/book/borrow?id=${book.id }">借阅</a>
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
	
	
	
	
	
</body>
</html>