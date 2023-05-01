package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录和注销Controller
 */
@Controller

public class UserController {
    //注入userService
    @Autowired
    private UserService userService;
    /*
   用户登录
    */
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        try {
            User u = userService.login(user);
            if (u != null) {
                request.getSession().setAttribute("USER_SESSION", u);
                return "redirect:/course/allCourse";
            }
            request.setAttribute("msg", "用户名或密码错误");
            return "forward:admin/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "系统错误");
            return "forward:admin/login.jsp";
        }

    }

    /*
    注销登录
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            //销毁Session
            session.invalidate();
            return "/WEB-INF/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "系统错误");
            return "/WEB-INF/login.jsp";
        }
    }

   /* *
     * 新增用户
     * @param user 新增的用户信息
    @ResponseBody
    @RequestMapping("/addUser")
    public Result addUser(User user) {
        try {
            userService.addUser(user);
            return new Result(true, "新增成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增失败!");
        }
    }*/


   /* *//**
     * 修改用户信息
     * @param user 修改的用户信息
     *//*
    @ResponseBody
    @RequestMapping("/editUser")
    public Result editUser(User user) {
        try {
            userService.editUser(user);
            return new Result(true, "修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败!");
        }
    }

    *//**
     * 查询用户
     * @param user 查询的条件
     * @param pageNum  数据列表的当前页码
     * @param pageSize 数据列表1页展示多少条数据
     *//*
    @RequestMapping("/search")
    public ModelAndView search(User user, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageResult pageResult = userService.searchUsers(user, pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("pageResult", pageResult);
        modelAndView.addObject("search", user);
        modelAndView.addObject("pageNum", pageNum);
        modelAndView.addObject("gourl", "/user/search");
        return modelAndView;
    }

    *//**
     * 根据id查询用户
     * @param id 用户id，用作查询条件
     *//*
    @ResponseBody
    @RequestMapping("/findById")
    public User findById(Integer id) {
        return userService.findById(id);
    }
*/
    /**
     * 检查用户名称是否已经存在
     * @param name 用户名称

    @ResponseBody
    @RequestMapping("/checkName")
    public Result checkName(String name) {
        Integer count = userService.checkName(name);
        if (count > 0) {
            return new Result(false, "名字重复!");
        } else {
            return new Result(true, "名字可用!");
        }
    }*/

}
