package cn.xzf.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzf.service.ServiceDB;

public class ReturnBookServlrt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServiceDB sdb=new ServiceDB();
		String id=request.getParameter("id");
		sdb.ReturnBook(id);
		response.sendRedirect("/admin/return");
		
	}

}
