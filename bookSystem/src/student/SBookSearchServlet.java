package student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzf.service.SServiceDB;

public class SBookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String txt=request.getParameter("txt");
		SServiceDB ssdb=new SServiceDB();
		
		request.setAttribute("booklist",ssdb.FindByTxt(txt));
		request.getRequestDispatcher("/WEB-INF/views/student/book/search.jsp").forward(request, response);
		}

}
