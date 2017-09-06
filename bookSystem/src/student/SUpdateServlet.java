package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xzf.entityAll.Student;
import cn.xzf.service.SServiceDB;

public class SUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			request.getRequestDispatcher("/WEB-INF/views/student/pwd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		SServiceDB ssdb=new SServiceDB();
		String password=request.getParameter("newpwd");
		HttpSession session=request.getSession();
		Student student=(Student)session.getAttribute("student");
		ssdb.SUpdate(password, student);
		response.sendRedirect("/student/main");
	}

}
