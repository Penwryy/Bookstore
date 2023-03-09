package com.baizhi.zfq.dao;

import com.baizhi.zfq.entity.User;

import java.util.List;

/**
 * @author ZhaoFuqiang
 * date 2022/11/21
 * description UserDao 的接口文件
 */

public interface UserDao {
    //查所有
    List<User> selectAll();
    //查一个
    User selectUserById(Integer id);
    void insertUser(User user);
    void deleteUserById(Integer id);
    void changeUser(User user);
    void updateUser(User user);
}
