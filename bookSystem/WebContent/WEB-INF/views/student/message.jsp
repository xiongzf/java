<%@page import="cn.xzf.entityAll.Message"%>
<%@page import="java.util.List"%>
<%@page import="cn.xzf.entityAll.Student"%>
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
	<jsp:include page="../include/sNavbar.jsp">
		<jsp:param value="message" name="menu"/>
	</jsp:include>
	
	<div class="container">
		<div class="well">
			<a class="btn btn-success" href="/student/new">发布留言</a>
		</div>
	</div>
	<c:if test="${empty mlist }">
		<div class="container">
			<div class="well">赶快发表留言哦</div>
		</div>
	</c:if>
	<c:forEach items="${mlist }" var="msg">
		<div class="container">
			<div class="well">
				<h3><small>发布者：${msg.stuname }</small></h3>
				<p>
					${msg.message }
				</p>
				<c:if test="${not empty msg.reply }">
					<h3><small>回复者：${msg.admname }</small></h3>
					<p>
						${msg.reply }
					</p>
				</c:if>
					<a ref="${msg.id }" href="javascript:;" class="dellink">删除</a>
			</div>
		</div>
	</c:forEach>	
	<script src="/js/jquery-1.10.1.min.js"></script>
	<script>
		$(function(){
			
			$(".dellink").click(function(){
				if(confirm("您确认要删除吗?")) {
					var id = $(this).attr("ref");
					location.href="/student/message/del?id="+id;
				}
			});
		});
	</script>
	
	
	
</body>
</html>