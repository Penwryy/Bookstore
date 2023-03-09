package com.baizhi.zfq.test;//package com.baizhi.zfq.test;

import com.baizhi.zfq.SWSWApplication;
import com.baizhi.zfq.dao.BookDao;
import com.baizhi.zfq.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SWSWApplication.class)
public class BookDaoTest {
    //自动注入，帮助自动的引入dao实现类，不需要mybatis那么多步骤
    //报错不管，这是spring的错，不是springboot
    @Autowired
    private BookDao bookDao;

    @Test
    public void testSelectBookLimit(){
        //数据库起始下表为零
        List<Book> bookList=bookDao.selectBookLimit(0);
        for (Book b:bookList) {
            System.out.println(b);
        }
    }
    @Test
    public void testSelectBookCount(){
        Integer sum=bookDao.selectBookCount();
        System.out.println(sum);
    }

    @Test
    public void testInsertBook(){
        Book book=new Book("no1","dldl",null,null,null,null,null,null,null);
        //bookDao.insertBook(book);
    }
}
