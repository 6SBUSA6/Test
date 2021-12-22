package com.gyw.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 高源蔚
 * @date 2021/9/1-20:33
 * @describe
 */
public class ConnUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private static DataSource dataSource;
    static
    {
        FileInputStream fis = null;
        Properties properties = new Properties();
        try {
            fis = new FileInputStream("D:\\IdeaWorkSpace\\Test\\Books_gyw\\src\\mysql.properties");
            properties.load(fis);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //获取数据库连接
    public static Connection getConnect() throws SQLException {
        Connection conn = threadLocal.get();
        if(conn == null || conn.isClosed())
        {
            conn = dataSource.getConnection();
            threadLocal.set(conn);
        }
        return conn;
    }

    //关闭数据库链接
    public static void closeConnect()
    {
        Connection conn = threadLocal.get();
        try {
            if (conn != null || !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            threadLocal.set(null);
        }
    }


}
