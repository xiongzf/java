package cn.xzf.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.xzf.db.AdminDao;
import cn.xzf.entityAll.Admin;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminDao ad=new AdminDao();
		String username=request.getParameter("username");
		String password=request.getParameter("pwd");
		Admin admin=ad.findAdmin(username);
		if(admin!=null&&password.equals(admin.getPassword()))
		{
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);
			
			admin.setLastaccessip(request.getRemoteAddr());
			ad.update(admin);
			response.sendRedirect("/admin/main");
		}
		else
		{
			response.sendRedirect("/admin/index?code=1001");
		}
	}

}
