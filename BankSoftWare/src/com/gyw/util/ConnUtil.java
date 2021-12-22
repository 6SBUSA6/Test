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
 * @date 2021-08-25-12:23 PM
 * @describe 数据库的工具类
 * 功能1：获取数据库链接
 * 功能2：关闭链接
 *
 */
public class ConnUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal();
    private static DataSource dataSource ;
    static
    {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("D:\\IdeaWorkSpace\\Test\\BankSoftWare\\mysql.properties");
            properties.load(fis);
            if (fis == null) {
                System.out.println("空的");
            }
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库链接
    public static Connection getConnect() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null || conn.isClosed())
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
            if(conn!=null && !conn.isClosed())
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            threadLocal.set(null);
        }
    }


}














