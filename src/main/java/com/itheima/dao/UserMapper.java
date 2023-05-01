package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 用户操作接口
 */
public interface UserMapper {
    @Select("select * from user where user_name=#{name} AND user_password=#{password} ")
    @Results(id = "userMap",value = {
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名。
            @Result(id = true,column = "user_id",property = "id"),
            @Result(column = "user_name",property = "name"),
            @Result(column = "user_password",property = "password"),
    })
    //用户登录
    User login(User user);
/*    //新增用户
    void addUser(User user);
    //编辑用户信息
    void editUser(User user);

    @Select({"<script>" +
            "SELECT * FROM user " +
            "where 1=1 " +
            "<if test=\"id != null\"> AND  user_id  like  CONCAT('%',#{id},'%')</if>" +
            "<if test=\"name != null\"> AND user_name like  CONCAT('%', #{name},'%') </if>" +
            "order by user_status" +
            "</script>"
    })
    @ResultMap("userMap")
    //搜索用户
    Page<User> searchUsers(User user );

    @Select(" select * from user where user_id=#{id}")
    @ResultMap("userMap")
    //根据用户id查询用户信息
    User findById(Integer id);

    @Select("select count(user_name) from user where user_name=#{name}")
    //检查用户名是否已经存在
    Integer checkName(String name);*/

}
