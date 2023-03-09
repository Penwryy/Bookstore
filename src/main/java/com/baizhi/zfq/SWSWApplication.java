package com.baizhi.zfq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhaoFuqiang
 * date 2022/11/23
 * description 三味书屋-springboot项目的启动类
 */

//表明这个类是一个springboot项目的启动类
@SpringBootApplication
//表明dao接口的存放位置
@MapperScan("com.baizhi.zfq.dao")
public class SWSWApplication {
    public static void main(String[] args) {
        //启动项目
        SpringApplication.run(SWSWApplication.class,args);
    }
}
