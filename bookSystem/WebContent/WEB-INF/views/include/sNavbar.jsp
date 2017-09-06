<%@page import="cn.xzf.entityAll.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String menu=request.getParameter("menu");%>
<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="#">图书管理系统</a>
			<ul class="nav">
				<li class="<%=menu.equals("main")?"active":"" %>"><a href="/student/main">首页</a></li>
				<li class="<%=menu.equals("search")?"active":"" %>"><a href="/student/search">搜索图书</a></li>
				<li class="<%=menu.equals("borrow")?"active":"" %>"><a href="/student/hborrow">已借图书</a></li>
				<li class="<%=menu.equals("message")?"active":"" %>"><a href="/student/message">留言</a></li>
			</ul>
			<%Student student=(Student)session.getAttribute("student"); %>
			<ul class="nav pull-right">
				<li><a href="#">欢迎您<%=student.getUsername() %></a></li>
				<li><a href=/quit>安全退出</a></li>
				<li><a href=/student/update>修改密码</a></li>
			</ul>
		</div>
		</div>
	</div>