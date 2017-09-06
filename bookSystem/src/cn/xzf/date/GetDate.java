package cn.xzf.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate 
{
	private String date;
	public String getNowDate()
	{
		Date data=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date=sdf.format(data);
		return date;
	}
}
