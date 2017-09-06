package cn.xzf.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzf.service.ServiceDB;

public class CardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceDB sdb=new ServiceDB();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		
		request.setAttribute("card",sdb.CardUpdate(id));
		request.getRequestDispatcher("/WEB-INF/views/card/update.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		
		String stuname=request.getParameter("stuname");
		String cardnum=request.getParameter("cardnum");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		String id=request.getParameter("id");
		sdb.CardUpdateP(stuname, cardnum, tel, address, id);
		response.sendRedirect("/admin/card");
	}

}
