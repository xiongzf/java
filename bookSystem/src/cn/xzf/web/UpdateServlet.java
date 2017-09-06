package cn.xzf.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzf.service.ServiceDB;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceDB sdb=new ServiceDB();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		request.setAttribute("book",sdb.UpdateG(id));
		request.getRequestDispatcher("/WEB-INF/views/book/update.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		
		String bookname=request.getParameter("bookname");
		String author=request.getParameter("author");
		String publish=request.getParameter("publish");
		String isbn=request.getParameter("isbn");
		String total=request.getParameter("total");
		String nownum=request.getParameter("nownum");
		String id=request.getParameter("id");
		
		sdb.UpdateP(bookname, author, publish, isbn, total, nownum, id);		
		response.sendRedirect("/admin/book");
	}
}
