package com.baizhi.zfq.entity;

import java.io.Serializable;

/**
 * @author ZhaoFuqiang
 * date 2022/11/21
 * description User的实体类
 */

//Serializable-线程序列化
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;

    public User(){

    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
