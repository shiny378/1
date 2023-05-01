package com.itheima.service;

import com.itheima.dto.PaginationDTO;
import com.itheima.pojo.Courses;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

/**
 * @version : V1.0
 * @ClassName: BookService
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/19 14:29
 */
public interface CourseService {
    int addCourse(Courses course);

    int deleteCourseById( int id);

    int updateCourse(Courses Course);

    Courses queryCourseById(int id);

    PaginationDTO queryAllCourse(Integer curPage, Integer pageSize);

    int queryCourseCountByName(@Param(value = "name")String name);

    PaginationDTO queryCourseByName(String name,Integer curPage, Integer pageSize);
    public boolean saveRegister(Courses courses, MultipartFile file);
}