<%@page import="cn.xzf.entityAll.Admin"%>
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
		<jsp:param value="search" name="menu"/>
	</jsp:include>
	<div class="container">
		<form action="/book/search" method="post" class="form-search">
			<input type="text" class="span4" name="txt"/>
			<button class="btn btn-primary form-action">搜索</button>
		</form>
	</div>
</body>
</html>