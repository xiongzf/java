package cn.xiongzf.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brks on 2017/9/6.
 */
public class MapRowMapper implements RowMapper<Map<String, Object>> {

    //利用map存储数据
    public Map<String, Object> mapperRow(ResultSet set) throws SQLException {
        Map<String, Object> map = new HashMap();
        ResultSetMetaData rsmd = set.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i < columnCount; i ++) {
            String columnName = rsmd.getColumnLabel(i);
            Object value = set.getObject(columnName);
            map.put(columnName, value);
        }
        return map;
    }
}
