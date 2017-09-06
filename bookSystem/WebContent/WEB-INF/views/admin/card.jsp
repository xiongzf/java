<%@page import="cn.xzf.entityAll.Admin"%>
<%@page import="cn.xzf.entityAll.Card"%>
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
		<jsp:param value="card" name="menu"/>
	</jsp:include>
	<div class="container">
		<div>
			<a class="btn btn-primary" href="/card/new">添加新借书证</a>
		</div>
		<table class="table">
			<thead>
				<tr>
				<th>姓名</th>
				<th>卡号</th>
				<th>电话</th>
				<th>地址</th>
				<th>编辑</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty cardlist}">
					<tr>
						<td colspan="4">没有任何数据，请先添加数据</td>
					</tr>
				</c:if>
				<c:forEach items="${cardlist }" var="card">
					<tr>
					<td>${card.stuname }</td>
					<td>${card.cardnum }</td>
					<td>${card.tel }</td>
					<td>${card.address }</td>
					<td>
						<a href="/card/update?id=${card.id }">修改</a>
						<a href="/card/delete?id=${card.id }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>