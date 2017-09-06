<%@page import="cn.xzf.entityAll.Message"%>
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
		<div class="well">
			<p>${message.getMessage()}</p>
		</div>
		<form action="/admin/reply?id=${message.getId()}" method="post">
			<label>内容</label>
			<textarea name="content" rows="5" class="span4"></textarea>
			<div class="formactions">
				<button class="btn btn-primary">回复</button>
			</div>
		</form>
	</div>
</body>
</html>