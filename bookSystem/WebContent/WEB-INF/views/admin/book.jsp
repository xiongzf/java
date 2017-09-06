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
		<jsp:param value="book" name="menu"/>
	</jsp:include>
	<div class="container">
		<div>
			<a class="btn btn-primary" href="/book/new">添加新书籍</a>
			<a class="btn btn-primary" href="/book/export">导出Excel数据</a>
			<a class="btn btn-primary" href="/book/import">导入Excel数据</a>
		</div>
		<table class="table">
			<thead>
				<tr>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>ISBN</th>
				<th>总数量</th>
				<th>现存数量</th>
				<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list }">
					<tr> 
						<td colspan="7">没有任何数据，请先添加书籍</td>
					</tr>
				</c:if>
				<c:forEach items="${list}" var="book">
					<tr>
							<td>${book.bookname}</td>
							<td>${book.author }</td>
							<td>${book.publish}</td>
							<td>${book.isbn }</td>
							<td>${book.total }</td>
							<td>${book.nownum }</td>
							<td>
								<a href="/book/update?id=${book.id }">修改</a>
								<a href="/book/delete?id=${book.id }">删除</a>
							</td>
						</tr>
				</c:forEach>	
			</tbody>
				
		</table>
	
	</div>
	
	
	
	
	
	
	
</body>
</html>