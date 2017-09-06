package cn.xiongzf.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by brks on 2017/9/6.
 */
public class ExRowMapper<T> implements RowMapper<T> {
    private Class<T> clazz;

    public ExRowMapper(Class<T> clazz) {
        this.clazz = clazz;
    }

    //给对象赋值
    public T mapperRow(ResultSet set) throws SQLException {
        T object = null;
        try {
            object = clazz.newInstance();
            ResultSetMetaData rsmd = set.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i < columnCount; i++) {
                String columnName = rsmd.getColumnLabel(i);
                Object columnValue = set.getObject(columnName);
                setMethodValue(object, columnName, columnValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    //利用反射赋值
    private void setMethodValue(T object, String columnName, Object columnValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String methodName = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                method.invoke(object, columnValue);
            }
        }
    }
}
