package cn.xzf.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzf.service.ServiceDB;

public class BookBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceDB sdb=new ServiceDB();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		request.setAttribute("book",sdb.Borrowbook(id));
		request.getRequestDispatcher("/WEB-INF/views/admin/borrow.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("cid");
		String bid=request.getParameter("bid");
		sdb.SavaBorrow(id, bid);
		response.sendRedirect("/admin/main?code=1002");
	}

}
