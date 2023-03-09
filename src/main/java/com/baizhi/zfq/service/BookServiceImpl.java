package com.baizhi.zfq.service;

import com.baizhi.zfq.dao.BookDao;
import com.baizhi.zfq.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author ZhaoFuqiang
 * date 2022/11/24
 * description
 */

//表明这是service文件
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    //当容器，存数据
    @Autowired
    private HttpSession httpSession;
    @Override
    public void selectBookByPage(Integer page) {
        Integer begin=(page-1)*5;
        List<Book> bookList=bookDao.selectBookLimit(begin);
        Integer count=bookDao.selectBookCount();
        //页数
        Integer pageNum=count/5;
        if(count%5!=0){
            pageNum += 1;
        }
        //需要将返回前端页面的数据 存储
        //存booklist 逗号前，你起的名字    逗号后，存入的数据
        httpSession.setAttribute("list",bookList);
        //存总页数
        httpSession.setAttribute("pageNum",pageNum);
        //存当前是哪一页
        httpSession.setAttribute("page",page);
    }

    @Override
    public void insertBook(Book book ,MultipartFile coverFile){
        //生成uuid 作为文件名及id 因为文件名和id都不能重复
        String uuid= UUID.randomUUID().toString();
        String fileSuffix=coverFile.getOriginalFilename().substring(coverFile.getOriginalFilename().lastIndexOf("."));
        //生成新的文件名(字符串拼接)
        String coverFileName=uuid+fileSuffix;
        //copy 上传的文件到项目的img文件夹中
        //获取img文件夹的真实路径
        String realPath=httpSession.getServletContext().getRealPath("/img");
        try {
            //新建一个文件需要两部分组成，一部分路径，一部分文件名
            coverFile.transferTo(new File(realPath,coverFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将文件名写入book对象
        book.setCoverFileName(coverFileName);
        //uuid 写入
        book.setId(uuid);
        //销量 写入
        book.setSale(0);
//        使用dao方法插入
            bookDao.insertBook(book);
    }

    @Override
    public void deleteBook(String id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book,MultipartFile coverFile) {
        String uuid= UUID.randomUUID().toString();
        String fileSuffix=coverFile.getOriginalFilename().substring(coverFile.getOriginalFilename().lastIndexOf("."));
        //生成新的文件名(字符串拼接)
        String coverFileName=uuid+fileSuffix;
        //copy 上传的文件到项目的img文件夹中
        //获取img文件夹的真实路径
        String realPath=httpSession.getServletContext().getRealPath("/img");
        try {
            //新建一个文件需要两部分组成，一部分路径，一部分文件名
            coverFile.transferTo(new File(realPath,coverFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将文件名写入book对象
        book.setId((String) httpSession.getAttribute("selectId"));
        book.setCoverFileName(coverFileName);
        book.setSale(0);
        bookDao.updateBook(book);

        //uuid 写入
        //book.setId(uuid);
        //销量 写入

//        使用dao方法插入

    }

    @Override
    public void selectBookById(Book book) {
        httpSession.setAttribute("selectId",book.getId());
        bookDao.selectBookById(book);
    }

    @Override
    public void selectBookFuzzy(String key,String value){
        value="%"+value+"%";
        if(key.equals("name")){
            List<Book> bookList=bookDao.selectBookByName(value);
            httpSession.setAttribute("list",bookList);
        }else if(key.equals("author")){
            List<Book> bookList=bookDao.selectBookByAuthor(value);
            httpSession.setAttribute("list",bookList);
        }else if(key.equals("press")){
            List<Book> bookList=bookDao.selectBookByPress(value);
            httpSession.setAttribute("list",bookList);
        }


    }
}
