package cn.xzf.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.xzf.service.ServiceDB;

public class CardNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/views/card/new.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		
		String stuname=request.getParameter("stuname");
		String cardnum=request.getParameter("cardnum");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		
		ServiceDB sdb=new ServiceDB();
		sdb.CardNew(stuname, cardnum, tel, address);
		response.sendRedirect("/admin/card");
	}

}
