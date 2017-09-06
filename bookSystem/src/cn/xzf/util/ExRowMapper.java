package cn.xzf.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ExRowMapper<T> implements RowMapper<T>
{
	private Class<T> clazz;
	public ExRowMapper(Class<T> clazz)
	{
		this.clazz=clazz;
	}
	public T mapperRow(ResultSet rs) throws SQLException 
	{
		T obj=null;
		try 
		{
			obj=clazz.newInstance();
			ResultSetMetaData rsmd=rs.getMetaData();
			int columnCount=rsmd.getColumnCount();//��ȡ�е�����
			for(int i=1;i<=columnCount;i++)
			{
				String columnName =rsmd.getColumnLabel(i);
				Object columnValue=rs.getObject(columnName);
				setMethodValue(obj,columnName,columnValue);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	private void setMethodValue(T obj, String columnName, Object columnValue) throws
	IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		String methodName = "set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);
		Method[] methods=clazz.getMethods();
		for(Method m:methods)
		{
			if(m.getName().equals(methodName))
			{
				m.invoke(obj,columnValue);
				break;
			}
		}
	}
	
}







