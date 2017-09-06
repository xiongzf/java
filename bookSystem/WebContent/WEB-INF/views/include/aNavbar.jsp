<%@page import="cn.xzf.entityAll.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<% String menu=request.getParameter("menu");%>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="#">图书管理系统</a>
			<ul class="nav">
				<li class="<%=menu.equals("main")?"active":"" %>"><a href="/admin/main">首页</a></li>
				<li class="<%=menu.equals("book")?"active":"" %>"><a href="/admin/book">图书管理</a></li>
				<li class="<%=menu.equals("card")?"active":"" %>"><a href="/admin/card">借书证管理</a></li>
				<li class="<%=menu.equals("search")?"active":"" %>"><a href="/admin/search">搜索图书</a></li>
				<li class="<%=menu.equals("return")?"active":"" %>"><a href="/admin/return">归还图书</a></li>
				<li class="<%=menu.equals("message")?"active":"" %>"><a href="/admin/message">学生留言</a></li>
			</ul>
			<%Admin admin=(Admin)session.getAttribute("admin"); %>
			<ul class="nav pull-right">
				<li><a href="#">欢迎您<%=admin.getUsername() %></a></li>
				<li><a href=/quit>安全退出</a></li>
			</ul>
		</div>
		</div>
	</div>
