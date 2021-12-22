package com.gyw.service.impl;

import com.gyw.bean.Books;
import com.gyw.dao.impl.BooksDaoImpl;
import com.gyw.service.BooksService;
import com.gyw.util.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/9/2-8:55
 * @describe 实现类处理事务
 */
public class BooksServiceImpl implements BooksService {
    BooksDaoImpl booksDao = new BooksDaoImpl();

    //查看所有书籍
    @Override
    public List<Books> showAllBooks() {
        List<Books> list = new ArrayList<>();
        try {
            list = booksDao.showAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return list; //返回一个集合
    }

    //添加新书
    @Override
    public boolean addBook(Books newBooks) {
        int count = 0; //受影响的行数
        try {
            count = booksDao.addBook(newBooks);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count>0; //返回是否添加成功
    }

    //查找书籍
    @Override
    public Books findBookById(int id) {
        Books book = null;
        try {
            book = booksDao.findBookById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return book;
    }

    //入库
    @Override
    public boolean inputStore(int id, int inputNum) {
        int count = 0; //影响行数
        Connection conn = null;
        try {
            conn = ConnUtil.getConnect();
            conn.setAutoCommit(false);  //关闭自动提交
            count = booksDao.inputStore(id, inputNum);
            conn.commit(); //提交事务
        } catch (SQLException e) {
            try {
                conn.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0; //返回是否修改成功
    }

    //出库
    @Override
    public boolean outputStore(int outId, int outputNum) {
        int count = 0; //影响行数
        Connection conn = null;
        try {
            conn = ConnUtil.getConnect();
            conn.setAutoCommit(false);  //关闭自动提交
            count = booksDao.outputStore(outId, outputNum);
            conn.commit(); //提交事务
        } catch (SQLException e) {
            try {
                conn.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            ConnUtil.closeConnect();
        }
        return count > 0; //返回是否修改成功
    }
}
