package cn.xzf.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class Execute {
    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static BasicDataSource dataSource;

    static {
        Properties prop = new Properties();
        try {
            prop.load(Execute.class.getClassLoader().getResourceAsStream("db.properties"));
            DRIVER = prop.getProperty("jdbc.driver");
            URL = prop.getProperty("jdbc.url");
            USERNAME = prop.getProperty("jdbc.username");
            PASSWORD = prop.getProperty("jdbc.password");

            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(DRIVER);
            dataSource.setUrl(URL);
            dataSource.setUsername(USERNAME);
            dataSource.setPassword(PASSWORD);
            dataSource.setInitialSize(5);
            dataSource.setMaxActive(20);
            dataSource.setMaxWait(5000);

        } catch (IOException e) {
            throw new RuntimeException("注册数据库失败", e);
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();

        } catch (SQLException e) {

            throw new RuntimeException("连接数据库失败", e);
        }
    }

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

    public <T> T findQuery(String sql, RowMapper<T> mapper, Object... params) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        T obj = null;
        try {
            st = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            rs = st.executeQuery();
            if (rs.next()) {
                obj = mapper.mapperRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, st, con);
        }
        return obj;
    }

    public <T> List<T> queeryForlist(String sql, RowMapper<T> mapper, Object... params) {
        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();
        try {
            st = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            rs = st.executeQuery();
            while (rs.next()) {
                T obj = mapper.mapperRow(rs);
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, st, con);
        }
        return list;
    }

    public void close(ResultSet rs, Statement st, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
