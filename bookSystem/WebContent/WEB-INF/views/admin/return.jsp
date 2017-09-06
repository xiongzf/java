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
		<jsp:param value="return" name="menu"/>
	</jsp:include>
	<div class="container">
			<input type="text" name="cardnum" class="cardnum" placeholder="请输入借书证号">
			<button class="btn btn-primary">搜索</button>
	</div>
	<div class="container hide" id="div">
		<table class="table">
			<thead>
				<tr>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>ISBN</th>
				<th>还书</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>
	<script src="/js/handlerbar.js"></script>
	<script src="/js/jquery-1.10.1.min.js"></script>
	<script type="text/x-handlebars-template" id="mst">
		<tr>
			<td>{{bookname}}</td>
			<td>{{author}}</td>
			<td>{{publish}}</td>
			<td>{{isbn}}</td>
			<td>
				<a href="/admin/returnbook?id={{id}}">还书</a>
			</td>
		</tr>
	</script>
	<script>
		$(function()
		{
			$(".btn").click(function()
			{
				var cardnum=$(".cardnum").val();
				$.post("/admin/return",{'cardnum':cardnum},function(json)
				{
					for(var i=0;i<json.length;i++)
					{
						var book=json[i];
						var html=$("#mst").html();
						var template=Handlebars.compile(html);
						var temp=template(book);
						$("tbody").append(temp);
					}
				});
				$("#div").show();
			});
		});
	
	
	
	
	
	
	
	
	
	
	</script>
</body>
</html>