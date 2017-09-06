package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xzf.entityAll.Student;
import cn.xzf.service.SServiceDB;

public class SHBorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		Student student=(Student)session.getAttribute("student");
		SServiceDB ssdb=new SServiceDB();
			
		request.setAttribute("blist",ssdb.SHBorrow(student));
			
		request.getRequestDispatcher("/WEB-INF/views/student/book/hborrow.jsp").forward(request, response);
	}

}
