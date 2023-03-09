package com.baizhi.zfq.dao;

import com.baizhi.zfq.entity.Book;

import java.util.List;

/**
 * @author ZhaoFuqiang
 * date 2022/11/23
 * description
 */

public interface BookDao {
    //图书的分页查询(limit)
    List<Book> selectBookLimit(Integer begin);
    //计算总条数
    Integer selectBookCount();
    void insertBook(Book book);
    void deleteBook(String id);
    void updateBook(Book book);
    Book selectBookById(Book book);
    List<Book> selectBookByName(String value);
    List<Book> selectBookByAuthor(String value);
    List<Book> selectBookByPress(String value);


}
