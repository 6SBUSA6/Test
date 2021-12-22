package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author GYW
 * @date 2021-08-24-10:42 AM
 * @describe
 */
public class test02 {


    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyw?characterEncoding=utf-8&serverTimezone=UTC", "root", "1234");
            PreparedStatement ps = conn.prepareStatement("select * from student where sno = 201245");
            ResultSet rs = ps.executeQuery();
            System.out.println(rs == null);
            while (rs.next())
            {
                System.out.println(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        }


    }

}




















