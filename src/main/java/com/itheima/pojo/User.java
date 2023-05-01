package com.itheima.pojo;

import java.io.Serializable;

public class User implements Serializable{
    private Integer id;       //用户id
    private String name;      //用户名称
    private String password;  //用户密码

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
