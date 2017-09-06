package cn.xzf.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter extends AbstractFilter {

	private String encode="UTF-8";
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException 
	{
		String code=config.getInitParameter("encode");
		if(code!=null)
		{
			encode=code;
		}
	}

}
