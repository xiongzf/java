<%@page import="cn.xzf.entityAll.Message"%>
<%@page import="java.util.List"%>
<%@page import="cn.xzf.entityAll.Admin"%>
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
		<jsp:param value="message" name="menu"/>
	</jsp:include>
	<div class="container">
		<div class="well">
			<c:if test="${empty mlist }">
				<div>暂时还没有留言哦</div>
			</c:if>
			<c:forEach items="${mlist }" var="msg">
				<div>
				<h3><small>发布者：${msg.stuname}</small></h3>
				<p>
					${msg.message}				
				</p>
				<c:if test="${not empty msg.reply }">
					<h3><small>回复者:${msg.admname}</small></h3>
					<p>
						${msg.reply}
					</p>
				</c:if>
				<a href="/admin/reply?id=${msg.id}">回复</a>	
				<a ref="${msg.id}" href="javascript:;" class="dellink">删除</a>
				</div>
			</c:forEach>
		</div>
	</div>
	<script src="/js/jquery-1.10.1.min.js"></script>
	<script>
		$(function(){
			
			$(".dellink").click(function(){
				if(confirm("您确认要删除吗?")) {
					var id = $(this).attr("ref");
					location.href="/admin/message/del?id="+id;
				}
			});
		});
	</script>
</body>
</html>