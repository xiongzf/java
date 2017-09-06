<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<style type="text/css">
	.div
	{
		width:300px;
		margin:120px auto 0px auto;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="container div">
			<h2>请选择</h2>
			<c:if test="${'1001'== param.code }">
				<div class="alert">
					用户名或密码错误
				</div>
			</c:if>
			<form method="post"  action="" id="form">
				<label>用户名</label>
				<input type="text" name="username" />
				<label>密码</label>
				<input type="password" name="pwd"/>
				<div class="form-action">
					<button class="btn btn-success">登陆</button>
				</div>
			</form>
			<label class="radio inline">
				<input type="radio" name="optionsRadios" value="option1" id="optionR1"/>学生
			</label>
			<label class="radio inline">
				<input type="radio" name="optionsRadios" value="option2" id="optionR2"/>管理员
			</label>
		</div>
	</div>
	<script src="/js/jquery-1.10.1.min.js"></script>
	<script>
		$(function()
		{
			$("#optionR1").click(function()
			{
				$("h2").text("学生登陆");
				$("#form").removeAttr("action");
				$("#form").attr("action","/student/login");	
				
			});
			$("#optionR2").click(function()
			{
				$("h2").text("管理员登陆");
				$("#form").removeAttr("action");
				$("#form").attr("action","/admin/login");
				
			});
			
		});
	
	
	
	
	
	
	
	
	
	
	
	</script>
	
</body>
</html>