package com.gyw.dao;

import com.gyw.bean.Books;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/9/2-8:56
 * @describe
 */
public interface BooksDao {
    List<Books> showAllBooks() throws SQLException;

    int addBook(Books newBooks) throws SQLException;

    Books findBookById(int id) throws SQLException;

    int inputStore(int id, int inputNum) throws SQLException;

    int outputStore(int outId, int outputNum) throws SQLException;
}
