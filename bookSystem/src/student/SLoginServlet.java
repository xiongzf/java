package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import cn.xzf.db.StudentDao;
import cn.xzf.entityAll.Student;

public class SLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		StudentDao sd=new StudentDao();
		String username=request.getParameter("username");
		String password=request.getParameter("pwd");
		
		Student student=sd.findByname(username);
		if(student!=null&&DigestUtils.shaHex(password).equals(student.getPassword()))
		{
			HttpSession session=request.getSession();
			session.setAttribute("student",student);
			
			response.sendRedirect("/student/main");
		}
		else
		{
			response.sendRedirect("/admin/index?code=1001");
		}
	}

}
