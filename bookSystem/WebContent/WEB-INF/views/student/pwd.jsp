<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<style type="text/css">
	.error
	{
		color:red;
	}
</style>
</head>
<body>
	<div class="container">
		<form action="/student/update" method="post" id="form">
			<label>旧密码</label>
			<input type="password" name="oldpwd" placeholder="请输入旧密码"/>
			<label>新密码</label>
			<input type="password" name="newpwd" id="password" placeholder="请输入新密码"/>
			<label>确认密码</label>
			<input type="password" name="renewpwd" placeholder="请再输入一次新密码"/>
			<div class="form-action">
				<button class="btn btn-success">修改</button>
			</div>
		</form>
	</div>
	<script src="/js/jquery-1.10.1.min.js"></script>
	<script src="/js/jquery.validate.min.js"></script>
	<script >
		$(function()
		{
			$("#form").validate
			(
				{
					errorClass:"error help-inline",
					errorElement:"span",
					rules:
					{
						oldpwd:
						{
							required:true,
							rangelength:[4,18]
						},
						newpwd:
						{
							required:true,
							rangelength:[4,18]
						},
						renewpwd:
						{
							required:true,
							equalTo:'#password',
							rangelength:[4,18]
						}
					},
					messages:
					{
						oldpwd:
						{
							required:"请输入旧密码",
							rangelength:"密码长度为4~18位"
						},
						newpwd:
						{
							required:"请输入新密码",
							rangelength:"密码长度为4~18位"
						},
						renewpwd:
						{
							required:"请输入再输一次密码",
							equalTo:"两次密码不一致",
							rangelength:"密码长度为4~18位"
						}
					}
				}
			);
		});
	
	
	
	</script>
</body>
</html>