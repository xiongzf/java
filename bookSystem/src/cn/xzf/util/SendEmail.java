package cn.xzf.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendEmail 
{
	public void run(String url,String subject, String content)
	{
		HtmlEmail email=new HtmlEmail();
		email.setHostName("smtp.sina.cn");
		email.setAuthentication("hpu_xzf@sina.com","xiong7910zf");
		email.setCharset("UTF-8");
		email.setTLS(true);
		
		try {
			email.setFrom("hpu_xzf@sina.com");
			email.setSubject(subject);
			email.setHtmlMsg(content);
			email.addTo(url);
			
			email.send();
			
		} catch (EmailException e) 
		{
			e.printStackTrace();
		}
	}
}
