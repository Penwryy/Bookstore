package com.baizhi.zfq.service;

import com.baizhi.zfq.entity.Book;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ZhaoFuqiang
 * date 2022/11/24
 * description  BookService层的接口文件
 */

public interface BookService {
    //分页查询
    void selectBookByPage(Integer page);
    //接受两部分内容 一部分是图书的基本信息（书名，作者等） 另一部分 封面本身
    void insertBook(Book book, MultipartFile coverFile);
    //1.获取图片文件的文件类型（文件后缀）
    void deleteBook(String id);

    void updateBook(Book book,MultipartFile coverFile);

    void selectBookById(Book book);

    void selectBookFuzzy(String key,String value);
}
