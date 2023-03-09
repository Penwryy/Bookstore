package com.baizhi.zfq.test;//package com.baizhi.zfq.test;

import com.baizhi.zfq.SWSWApplication;
import com.baizhi.zfq.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SWSWApplication.class)

    public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private HttpSession httpSession;
    @Test
    public void testSelectBookByPage(){
        bookService.selectBookByPage(2);
        System.out.println(httpSession.getAttribute("list"));
        System.out.println(httpSession.getAttribute("pageNum"));
        System.out.println(httpSession.getAttribute("page"));
    }
}
