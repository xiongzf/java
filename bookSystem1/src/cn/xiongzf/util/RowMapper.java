package cn.xiongzf.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by brks on 2017/9/6.
 */
public interface RowMapper <T> {
    public T mapperRow(ResultSet set) throws SQLException;
}
