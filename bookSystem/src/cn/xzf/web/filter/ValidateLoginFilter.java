package cn.xzf.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xzf.entityAll.Admin;
import cn.xzf.entityAll.Student;
public class ValidateLoginFilter extends AbstractFilter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String url=req.getRequestURI();
		if(url.equals("/")||url.equals("/index.jsp")||url.equals("/admin/index")||url.equals("/student/login")||url.equals("/admin/login")||url.startsWith("/img/")||url.startsWith("/css/")||url.startsWith("/js/"))
		{
			chain.doFilter(request, response);
		}else
		{
			HttpSession session=req.getSession();
			Admin admin=(Admin) session.getAttribute("admin");
			Student student=(Student)session.getAttribute("student");
			if(admin==null)
			{
				if(student==null)
				{
					resp.sendRedirect("/admin/index?code=1001");
				}
				else
				{
					chain.doFilter(request, response);
				}
			}else
			{
				chain.doFilter(request, response);
			}
		}
		
	}
}






