package cn.xzf.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xzf.entityAll.Admin;
import cn.xzf.service.ServiceDB;

public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceDB sdb=new ServiceDB();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		
		request.setAttribute("message",sdb.ReplayG(id));
		request.getRequestDispatcher("/WEB-INF/views/admin/reply.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String reply=request.getParameter("content");
		HttpSession session=request.getSession();
		Admin admin=(Admin) session.getAttribute("admin");
		sdb.ReplayP(admin, id, reply);
		response.sendRedirect("/admin/message");
	}

}
