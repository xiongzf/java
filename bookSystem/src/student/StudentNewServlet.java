package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xzf.entityAll.Student;
import cn.xzf.service.SServiceDB;

public class StudentNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/views/student/message/new.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		Student student=(Student)session.getAttribute("student");
		request.setCharacterEncoding("UTF-8");
		String message=request.getParameter("content");
		SServiceDB ssdb=new SServiceDB();
		ssdb.StudentNew(student, message);
		
		response.sendRedirect("/student/message");
		
	}

}
