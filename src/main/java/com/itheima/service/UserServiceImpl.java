package com.itheima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.UserMapper;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *用户接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    //注入userMapper
    @Autowired
    private UserMapper userMapper;
    //通过User的用户账号和用户密码查询用户信息
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    /**
     * 新增用户
     * @param user 新增的用户信息
     *//*
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    *//**
     * 编辑用户信息
     * @param user 更新之后的用户信息
     *//*
    public void editUser(User user) {
        userMapper.editUser(user);
    }

    *//**
     * 搜索用户
     * @param user 搜索的条件
     * @param pageNum 当前页码
     * @param pageSize 每页显示数量
     * @return
     *//*
    public PageResult searchUsers(User user, Integer pageNum, Integer pageSize) {
        // 使用分页插件:
        PageHelper.startPage(pageNum, pageSize);
        Page<User> page =  userMapper.searchUsers(user);
        return new PageResult(page.getTotal(),page.getResult());
    }

    *//**
     * 根据用户id查询用户信息
     * @param id 用户id
     *//*
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    *//**
     * 检查用户名是否已经存在
     * @param name 待检查的用户名
     *//*
    @Override
    public Integer checkName(String name) {
        return userMapper.checkName(name);
    }
*/
}
