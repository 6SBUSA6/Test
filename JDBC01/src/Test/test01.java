package Test;

import java.sql.*;
import java.util.ArrayList;
/**
 * @author 高源蔚
 * @date 2021-08-24-12:22 PM
 * @describe
 */
public class test01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyw?characterEncoding=utf-8&serverTimezone=UTC", "root", "1234");
        //声明
        Statement st = conn.createStatement();
        //执行sql得到结果集
        String sql = "select * from student order by sno";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next())
        {
            System.out.println(rs.getInt("sno")+" "+rs.getString("sname")+" "+rs.getString("ssex")+" " +rs.getString("class"));
        }

    }

}
