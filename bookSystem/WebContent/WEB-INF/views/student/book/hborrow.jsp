<%@page import="cn.xzf.db.BookDao"%>
<%@page import="cn.xzf.entityAll.Book"%>
<%@page import="cn.xzf.entityAll.Borrow"%>
<%@page import="java.util.List"%>
<%@page import="cn.xzf.entityAll.Student"%>
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
	<jsp:include page="../../include/sNavbar.jsp">
		<jsp:param value="borrow" name="menu"/>
	</jsp:include>
	<div class="container">
			
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
				<%
					BookDao bd=new BookDao();
					Book book=new Book();
					List<Borrow> list=(List<Borrow>)request.getAttribute("blist");
					for(Borrow borrow:list)
					{
						book=bd.findByid(borrow.getBid());
				%>
					<tr>
							<td><%=book.getBookname() %></td>
							<td><%=book.getAuthor() %></td>
							<td><%=book.getPublish() %></td>
							<td><%=book.getIsbn() %></td>
							<td>
								<a href="/student/return?id=<%=book.getId()%>">还书</a>
							</td>
					</tr>
				<%} %>
			</tbody>
				
		</table>
	</div>
	
</body>
</html>