package com.gyw.dao.impl;

import com.gyw.bean.Books;
import com.gyw.dao.BooksDao;
import com.gyw.util.ConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/9/2-8:56
 * @describe 永久层
 */
public class BooksDaoImpl implements BooksDao {

    //查询所有书籍
    @Override
    public List<Books> showAllBooks() throws SQLException {
        Connection conn = ConnUtil.getConnect();  //建立链接
        List<Books> list = new ArrayList<>();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from books");
        //遍历结果集
        while (rs.next())
        {
            Books books = new Books();
            books.setId(rs.getInt("id"));
            books.setName(rs.getString("name"));
            books.setAuthor(rs.getString("author"));
            books.setPrice(rs.getDouble("price"));
            books.setPub_date(rs.getDate("pub_date"));
            books.setStore(rs.getInt("store"));
            list.add(books);
        }
        return list;
    }

    //添加新数
    @Override
    public int addBook(Books newBooks) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("insert into books(name, author, price, pub_date, store) " +
                "values (?,?,?,?,?)");
        ps.setString(1,newBooks.getName());
        ps.setString(2,newBooks.getAuthor());
        ps.setDouble(3,newBooks.getPrice());
        ps.setDate(4,newBooks.getPub_date());
        ps.setInt(5,newBooks.getStore());
        return ps.executeUpdate(); //返回受影响的行数
    }

    //查找书籍
    @Override
    public Books findBookById(int id) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("select * from books where id =?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Books books = new Books();
        while(rs.next())
        {
            books.setId(rs.getInt("id"));
            books.setName(rs.getString("name"));
            books.setAuthor(rs.getString("author"));
            books.setPrice(rs.getDouble("price"));
            books.setPub_date(rs.getDate("pub_date"));
            books.setStore(rs.getInt("store"));
        }
        return books; //返回实体
    }

    //入库
    @Override
    public int inputStore(int id, int inputNum) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("update books set store = store + ? where id = ?");
        ps.setInt(1,inputNum);
        ps.setInt(2,id);
        return  ps.executeUpdate(); //返回受影响的行数
    }

    //出库
    @Override
    public int outputStore(int outId, int outputNum) throws SQLException {
        Connection conn = ConnUtil.getConnect();
        PreparedStatement ps = conn.prepareStatement("update books set store = store - ? where id = ?");
        ps.setInt(1,outputNum);
        ps.setInt(2,outId);
        return  ps.executeUpdate(); //返回受影响的行数
    }
}
