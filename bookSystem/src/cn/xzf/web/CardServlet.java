package cn.xzf.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xzf.db.CardDao;
import cn.xzf.entityAll.Admin;
import cn.xzf.entityAll.Card;

public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		Admin admin=(Admin) session.getAttribute("admin");
		if(admin==null)
		{
			response.sendRedirect("/admin/index?code=1001");
		}else
		{
		CardDao cd=new CardDao();
		List<Card> list=cd.findAll();
		request.setAttribute("cardlist",list);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/card.jsp").forward(request, response);
	
		}
	}

}
