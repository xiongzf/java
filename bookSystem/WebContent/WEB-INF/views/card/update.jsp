<%@page import="cn.xzf.entityAll.Card"%>
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
		<jsp:param value="card" name="menu"/>
	</jsp:include>
	<div class="container">
		<form action="/card/update?id=${card.id }" method="post">
			<legend>修改借书证</legend>
			<label>姓名</label>
			<input type="text" name="stuname" value="${card.stuname }"/>
			<label>卡号</label>
			<input type="text" name="cardnum" value="${card.cardnum }"/>
			<label>电话</label>
			<input type="text" name="tel" value="${card.tel }"/>
			<label>地址</label>
			<input type="text" name="address" value="${card.address }"/>
			<div>
				<button class="btn btn-success form-action">修改</button>
			</div>
			
		</form>
	</div>
</body>
</html>