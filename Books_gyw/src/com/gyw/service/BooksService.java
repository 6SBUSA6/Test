package com.gyw.service;

import com.gyw.bean.Books;

import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/9/2-8:55
 * @describe 接口
 */
public interface BooksService {
    List<Books> showAllBooks();

    boolean addBook(Books newBooks);

    Books findBookById(int id);

    boolean inputStore(int id, int inputNum);

    boolean outputStore(int outId, int outputNum);
}
