package com.gyw.controller;

import com.gyw.bean.Books;
import com.gyw.service.impl.BooksServiceImpl;

import java.util.List;

/**
 * @author 高源蔚
 * @date 2021/9/2-8:54
 * @describe 接受请求
 */
public class BooksController {
    BooksServiceImpl booksService = new BooksServiceImpl();

    public List<Books> showAllBooks() {
        return booksService.showAllBooks();
    }

    public boolean addBook(Books newBooks) {
        return booksService.addBook(newBooks);
    }

    public Books findBookById(int id) {
        return booksService.findBookById(id);
    }

    public boolean inputStore(int id, int inputNum) {
        return booksService.inputStore(id, inputNum);
    }

    public boolean outputStore(int outId, int outputNum) {
        return booksService.outputStore(outId, outputNum);
    }
}
