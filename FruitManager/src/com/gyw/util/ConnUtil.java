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
 * @date 2021/8/30-14:17
 * @describe 数据库工具类
 */
public class ConnUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private static DataSource dataSource;
    static
    {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\IdeaWorkSpace\\Test\\FruitManager\\mysql.properties");
            properties.load(fis);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
