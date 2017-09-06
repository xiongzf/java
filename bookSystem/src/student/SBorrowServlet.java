package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xzf.entityAll.Student;
import cn.xzf.service.SServiceDB;

public class SBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		Student student=(Student)session.getAttribute("student");
		String id=request.getParameter("id");
		SServiceDB ssdb=new SServiceDB();
		ssdb.Sborrow(student, id);
		response.sendRedirect("/student/main");
	}

}
