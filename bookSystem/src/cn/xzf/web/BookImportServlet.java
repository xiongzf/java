package cn.xzf.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import cn.xzf.service.ServiceDB;

public class BookImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/WEB-INF/views/admin/import.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//1.文件上传
		if(ServletFileUpload.isMultipartContent(request))
		{
			ServletFileUpload uploader=new ServletFileUpload(new DiskFileItemFactory());
			try
			{
				List<FileItem>list=uploader.parseRequest(request);
				for(FileItem item:list)
				{
					if(!item.isFormField())
					{
						if(item.getFieldName().equals("dataFile"))
						{
							InputStream is=item.getInputStream();
							ServiceDB sdb=new ServiceDB();
							sdb.ImportExcel(is);
						}
					}
				}
			}catch(FileUploadException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("表单设置有误");
		}
		response.sendRedirect("/admin/main");
	}

}
