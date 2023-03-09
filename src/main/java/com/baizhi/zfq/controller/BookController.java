package com.baizhi.zfq.controller;

import com.baizhi.zfq.entity.Book;
import com.baizhi.zfq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ZhaoFuqiang
 * date 2022/11/24
 * description
 */
//表明这是个controller文件
@Controller
//前端页面可以通过端口＋book找到这个controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("selectBookByPage")
    public String selectBookByPage(Integer page){
        bookService.selectBookByPage(page);
        return "redirect:/show.jsp";
    }
    @RequestMapping("insertBook")
    public String insertBook(Book book, MultipartFile coverFile) throws Exception{
        //调用service方法
        System.out.println("111");
//        bookService.insertBook(book,coverFile);
        //调回分页查询的方法
        return "redirect:/book/selectBookByPage?page=1";
    }
    @RequestMapping("deleteBook")
    public String deleteBook(String id){

        bookService.deleteBook(id);
        return "redirect:/book/selectBookByPage?page=1";
    }
    @RequestMapping("updateBook")
    public String updateBookById(Book book, MultipartFile coverFile){
        bookService.updateBook(book ,coverFile);
        return "redirect:/book/selectBookByPage?page=1";
    }
    @RequestMapping("selectBookById")
    public String selectBookById(Book book){
        bookService.selectBookById(book);
        return "redirect:/update.jsp";
    }
    @RequestMapping("selectBookFuzzy")
    public String selectBookFuzzy(String key,String value){
        bookService.selectBookFuzzy(key, value);
        return "redirect:/show.jsp";
    }
}
