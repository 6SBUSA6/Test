package com.gyw.dao;

import com.gyw.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021-08-24-5:19 PM
 * @describe
 */
public class StudentDao {
    public List<Student> showAllStudent()
    {
        //展示所有学生
        ArrayList<Student> stuList = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        String sql = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyw?characterEncoding=utf-8&serverTimezone=UTC", "root", "1234");
            st = conn.createStatement();
            sql = "select * from student order by sno";
            rs = st.executeQuery(sql);
            while(rs.next())
            {
                Student stu = new Student(rs.getInt("sno"),rs.getString("sname")
                ,rs.getString("ssex"), rs.getString("class"));
                stuList.add(stu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

                try {
                    if (conn != null) {
                        conn.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
        return stuList;
    }
    //查找性别为男女的同学
    public List<Student> findStuBySex(String sex)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> stuList = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyw?characterEncoding=utf-8&serverTimezone=UTC", "root", "1234");
            ps = conn.prepareStatement("select * from student where ssex = ?");
            ps.setString(1,sex);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Student stu = new Student(rs.getInt("sno"),rs.getString("sname")
                        ,rs.getString("ssex"), rs.getString("class"));
                stuList.add(stu);
            }
        } catch (SQLException e) {

                try {
                    if (rs != null) {
                    rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            e.printStackTrace();
        }
        return stuList;
    }

    //添加数据
    public int addStudent(Student stu)
    {
        Connection conn = null;
        int i = 0;
        PreparedStatement ps = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyw?characterEncoding=utf-8&serverTimezone=UTC", "root", "1234");
            ps = conn.prepareStatement("insert into student(sno, sname, ssex, class) " +
                    "values(?,?,?,?) ");
            ps.setInt(1,stu.getSid());
            ps.setString(2,stu.getSnaame());
            ps.setString(3,stu.getSsex());
            ps.setString(4,stu.getClasses());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return i;
    }

    //删除指定的同学
    public int deleteStuBySno(int sno)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyw?characterEncoding=utf-8&serverTimezone=UTC", "root", "1234");
            ps = conn.prepareStatement("delete from student where sno = ?");
            ps.setInt(1,sno);
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    //修改学生信息
    public int updateStu(Student stu)
    {
        Connection conn = null;
        PreparedStatement ps =null;
        int i = 0;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyw?characterEncoding=utf-8&serverTimezone=UTC", "root", "1234");
            ps = conn.prepareStatement("update student set sno = ?, sname = ?" +
                    ", ssex = ?, class = ? where sno = ?");
            ps.setInt(1,stu.getSid());
            ps.setString(2,stu.getSnaame());
            ps.setString(3,stu.getSsex());
            ps.setString(4,stu.getClasses());
            ps.setInt(5,stu.getSid());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }
    



}
