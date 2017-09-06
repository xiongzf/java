package cn.xiongzf.util;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by brks on 2017/9/5.
 *
 * 操作数据库
 */
public class Execute {
    private static String Driver;
    private static String Url;
    private static String Username;
    private static String Password;
    private static BasicDataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Execute.class.getClassLoader().getResourceAsStream("db.properties"));
            Driver = properties.getProperty("jdbc.driver");
            Url = properties.getProperty("jdbc.url");
            Username = properties.getProperty("jdbc.username");
            Password = properties.getProperty("jdbc.password");

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(Driver);
            dataSource.setUrl(Url);
            dataSource.setUsername(Username);
            dataSource.setPassword(Password);
            dataSource.setInitialSize(5);
            dataSource.setMaxActive(20);
            dataSource.setMaxWait(5000);

        } catch (IOException e) {
            throw new RuntimeException("注册数据库失败", e);
        }
    }

    //连接数据库
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("连接数据库失败", e);
        }
    }

    //执行添加、删除、修改操作
    public void executeUp(String sql, Object... params) {
        Connection con = getConnection();
        PreparedStatement st = null;

        try {
            st = con.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, st, con);
        }
    }

    //查询单个结果
    public <T> T findQuery(String sql, RowMapper<T> mapper, Object... params) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        T obj = null;

        try {
            ps = con.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1; params[i]);
            }

            rs = ps.executeQuery();

            if (rs.next()) {
                obj = mapper.mapperRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, con);
        }

        return obj;
    }

    //访问数据库，查询多个结果
    public <T> List<T> queeryForList(String sql, RowMapper<T> mapper, Object... params) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();

        try {
            ps = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i ++) {
                ps.setObject(i + 1, params[i]);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                T obj = mapper.mapperRow(rs);
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, connection);
        }

        return list;
    }

    //关闭访问数据库的相关设置
    public void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

}







