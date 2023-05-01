package com.itheima.dao;

import com.itheima.pojo.Courses;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @version : V1.0
 * @ClassName: BookMapper
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/19 14:11
 */
public interface CourseMapper {
    int addCourse(Courses courses);//增
    int deleteCourseById(@Param(value = "id") int id);//删
    int updateCourse(Courses course);//改
    Courses queryCourseById(@Param(value = "id")int id);//查
    List<Courses> queryAllCourse(@Param(value = "curPage")int curPage, @Param(value = "pageSize")int pageSize);
    List<Courses> queryCourseByName(@Param(value = "name")String name, @Param(value = "curPage")int curPage, @Param(value = "pageSize")int pageSize);
    int queryCourseCount();
    int queryCourseCountByName(@Param(value = "name")String name);

}