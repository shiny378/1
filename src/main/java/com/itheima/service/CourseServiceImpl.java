package com.itheima.service;

import com.itheima.dao.CourseMapper;
import com.itheima.dto.PaginationDTO;
import com.itheima.pojo.Courses;
import com.itheima.util.Constants;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public int addCourse(Courses course) {
        return courseMapper.addCourse(course);
    }

    public int deleteCourseById(int id) {
        return courseMapper.deleteCourseById(id);
    }

    public int updateCourse(Courses course) {
        return courseMapper.updateCourse(course);
    }

    public Courses queryCourseById(int id) {
        return courseMapper.queryCourseById(id);
    }

    @Override
    public int queryCourseCountByName(String name) {
        return courseMapper.queryCourseCountByName(name);
    }

    public PaginationDTO queryAllCourse(Integer curPage, Integer pageSize) {
        PaginationDTO<Object> paginationDTO = new PaginationDTO<>();
        Integer totalPage;
        Integer totalCount = courseMapper.queryCourseCount();
        if(totalCount % pageSize == 0){
            totalPage = totalCount / pageSize;
        }else {
            totalPage = totalCount / pageSize + 1;
        }
        if (curPage < 1){
            curPage = 1;
        }
        if (curPage > totalPage){
            curPage = totalPage;
        }

        paginationDTO.setPagination(totalPage,curPage);
        Integer offset = pageSize * (curPage - 1);

        List<Courses> courses = courseMapper.queryAllCourse(offset, pageSize);
        paginationDTO.setData(courses);

        return paginationDTO;
    }

    public PaginationDTO queryCourseByName(String name,Integer curPage, Integer pageSize) {
        PaginationDTO<Object> paginationDTO = new PaginationDTO<>();
        Integer totalPage;
        Integer totalCount = courseMapper.queryCourseCountByName(name);
        if (totalCount.equals(0)) {
            return paginationDTO;
        }
        if(totalCount % pageSize == 0){
            totalPage = totalCount / pageSize;
        }else {
            totalPage = totalCount / pageSize + 1;
        }
        if (curPage < 1){
            curPage = 1;
        }
        if (curPage > totalPage){
            curPage = totalPage;
        }

        paginationDTO.setPagination(totalPage,curPage);
        Integer offset = pageSize * (curPage - 1);

        List<Courses> courses = courseMapper.queryCourseByName(name,offset,pageSize);
        paginationDTO.setData(courses);

        return paginationDTO;

    }

    public boolean saveRegister(Courses courses, MultipartFile file){
        if (file != null){
            // 原始文件名
            String originalFileName = file.getOriginalFilename();
            // 获取图片后缀
            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
            String fileName = UUID.randomUUID().toString() + suffix;
            // 图片存储路径
            String filePath = Constants.IMG_PATH + fileName;
            File saveFile = new File(filePath);
            try {
                // 将上传的文件保存到服务器文件系统
                file.transferTo(saveFile);
                // 记录服务器文件系统图片名称
                courses.setPic(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 持久化 user
        return courseMapper.addCourse(courses) > 0;
    }

}