package cn.xzf.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MapRowMapper implements RowMapper<Map<String,Object>>
{

	public Map<String, Object> mapperRow(ResultSet rs) throws SQLException 
	{
		Map<String, Object>map=new HashMap<String, Object>();
		ResultSetMetaData rsmd=rs.getMetaData();
		int columnCount=rsmd.getColumnCount();
		for (int i = 1; i <= columnCount; i++) 
		{
			String columnName=rsmd.getColumnLabel(i);
			Object value=rs.getObject(columnName);
			map.put(columnName, value);
		}
		return map;
	}
	
}




