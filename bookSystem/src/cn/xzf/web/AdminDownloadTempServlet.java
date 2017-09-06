package cn.xzf.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminDownloadTempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment;filename=\"temp.xls\"");
		
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(new File("G:/upload/temp.xls")));
		BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
		
		byte[] buffer=new byte[1024];
		int len=-1;
		while((len=bis.read(buffer))!=-1)
		{
			bos.write(buffer, 0, len);
		}
		bos.flush();
		bos.close();
		bis.close();
	}
}
