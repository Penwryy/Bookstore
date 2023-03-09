package com.baizhi.zfq.test;

import com.baizhi.zfq.dao.UserDao;
import com.baizhi.zfq.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;


/**
 * @author ZhaoFuqiang
 * date 2022/11/21
 * description
 */

public class TestUserDao {
    @Test
    public void testSelectAll() throws Exception{
        //建造工厂，到工厂生产产品的过程
        //1.创建工人
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //2.获取建造材料
        Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
        //3.建立工厂
        SqlSessionFactory factory =builder.build(reader);
        //4.工厂开始生产产品
        SqlSession session=factory.openSession();
        //使用生产的SqlSession 来获取userdao接口的实现类对象
        UserDao userDao=session.getMapper(UserDao.class);
        List<User> list=userDao.selectAll();

        for(User user:list){
            System.out.println(user);
        }
        //处理使用完成的sqlsession
        session.close();
    }
    @Test
    public void testSelectById() throws Exception{
        //建造工厂，到工厂生产产品的过程
        //1.创建工人
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //2.获取建造材料
        Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
        //3.建立工厂
        SqlSessionFactory factory =builder.build(reader);
        //4.工厂开始生产产品
        SqlSession session=factory.openSession();
        //使用生产的SqlSession 来获取userdao接口的实现类对象
        UserDao userDao=session.getMapper(UserDao.class);
        User user=userDao.selectUserById(10);
        System.out.println(user);
        //处理使用完成的sqlsession
        session.close();
    }
    @Test
    public void testInsertUser() throws Exception{
        //建造工厂，到工厂生产产品的过程
        //1.创建工人
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //2.获取建造材料
        Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
        //3.建立工厂
        SqlSessionFactory factory =builder.build(reader);
        //4.工厂开始生产产品
        SqlSession session=factory.openSession();
        //使用生产的SqlSession 来获取userdao接口的实现类对象
        UserDao userDao=session.getMapper(UserDao.class);
        userDao.insertUser(new User(1001,"test1",20));
        session.commit();
        //处理使用完成的sqlsession
        session.close();
    }
    @Test
    public void testDeleteUserById() throws Exception{
        //建造工厂，到工厂生产产品的过程
        //1.创建工人
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //2.获取建造材料
        Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
        //3.建立工厂
        SqlSessionFactory factory =builder.build(reader);
        //4.工厂开始生产产品
        SqlSession session=factory.openSession();
        //使用生产的SqlSession 来获取userdao接口的实现类对象
        UserDao userDao=session.getMapper(UserDao.class);
        userDao.deleteUserById(1001);
        session.commit();
        //处理使用完成的sqlsession
        session.close();
    }
    @Test
    public void testUpdateUser() throws Exception{
        //建造工厂，到工厂生产产品的过程
        //1.创建工人
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //2.获取建造材料
        Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
        //3.建立工厂
        SqlSessionFactory factory =builder.build(reader);
        //4.工厂开始生产产品
        SqlSession session=factory.openSession();
        //使用生产的SqlSession 来获取userdao接口的实现类对象
        UserDao userDao=session.getMapper(UserDao.class);
        userDao.updateUser(new User(1001,"test2update",39));

        session.commit();
        //处理使用完成的sqlsession
        session.close();
    }
}
