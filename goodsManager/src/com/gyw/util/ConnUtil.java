package com.gyw.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 高源蔚
 * @date 2021/8/31-10:45
 * @describe
 */
public class ConnUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private static DataSource ds;
    static
    {
        try {
            Properties properties = new Properties();
            /*InputStream inputStream = ConnUtil.class.getResourceAsStream("D:\\IdeaWorkSpace\\Test\\goodsManager\\src\\mysql.properties");
            properties.load(inputStream);*/
            FileInputStream fis = new FileInputStream("D:\\IdeaWorkSpace\\Test\\Books_gyw\\src\\mysql.properties");
            properties.load(fis);
            ds = BasicDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    //建立连接
    public static Connection getConn() throws SQLException {
        Connection conn = threadLocal.get();

            if(conn == null || conn.isClosed())
            {
                conn = ds.getConnection();
                threadLocal.set(conn);
            }

        return conn;
    }

    //关闭链接
    public static void closeConn() {
        Connection conn = threadLocal.get();
        try {
            if (conn != null && !conn.isClosed())
            {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            threadLocal.set(null);
        }
    }


}
