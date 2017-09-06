package cn.xiongzf.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.Properties;

/**
 * Created by brks on 2017/9/6.
 */
public class SendEmail {
    private String USERNAME;
    private String PASSWORD;
    public Properties properties = null;

    public void run(String url, String subject, String content) throws Exception {
        properties.load(Execute.class.getClassLoader().getResourceAsStream("email.properties"));
        USERNAME = properties.getProperty("userName");
        PASSWORD = properties.getProperty("password");

        HtmlEmail email = new HtmlEmail();
        email.setHostName("stmp.sina.cn");
        email.setAuthentication(USERNAME, PASSWORD);
        email.setTLS(true);

        email.setFrom(USERNAME);
        email.setSubject(subject);
        email.setHtmlMsg(content);
        email.addTo(url);

        email.send();
    }
}
