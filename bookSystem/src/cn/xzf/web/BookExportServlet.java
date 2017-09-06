package cn.xzf.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzf.service.ServiceDB;

public class BookExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//1.生成Excel
		
		//2.下载设置
		//设置文件头
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename=\"data.xls\"");
		OutputStream os=response.getOutputStream();
		ServiceDB sdb=new ServiceDB();
		sdb.ExportExcel(os);
	}
}
