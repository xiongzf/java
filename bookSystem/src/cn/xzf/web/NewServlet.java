package cn.xzf.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzf.service.ServiceDB;

public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/views/book/new.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String bookname=request.getParameter("bookname");
		String author=request.getParameter("author");
		String publish=request.getParameter("publish");
		String isbn=request.getParameter("isbn");
		String total=request.getParameter("total");
		
		ServiceDB sdb=new ServiceDB();
		sdb.NewBook(bookname, author, publish, isbn, total);
		response.sendRedirect("/admin/book");
	}

}
