package com.itheima.controller;

import com.itheima.dto.PaginationDTO;
import com.itheima.pojo.Courses;
import com.itheima.service.CourseService;
import com.itheima.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/allCourse")
    public String list(Model model,
                       @RequestParam(name="curPage",defaultValue = "1") Integer curPage,
                       @RequestParam(name = "pageSize",defaultValue = "5")Integer pageSize){
        PaginationDTO paginationDTO = courseService.queryAllCourse(curPage,pageSize);
        model.addAttribute("list",paginationDTO);
        return "allCourse";

    }

    @RequestMapping("/toAddCourse")
    public String toAddPaper() {
        return "addCourse";
    }

    @RequestMapping("/addCourse")
    public String addPaper(Courses courses) {
        System.out.println(courses);
        courseService.addCourse(courses);
        return "redirect:/course/allCourse";
    }

    @RequestMapping("/toUpdateCourse")
    public String toUpdateCourse(Model model, int id) {
        Courses courses = courseService.queryCourseById(id);
        System.out.println(courses);
        model.addAttribute("course",courses );
        return "updateCourse";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(Model model, Courses course) {
        System.out.println(course);
        courseService.updateCourse(course);
        Courses courses = courseService.queryCourseById(course.getId());
        model.addAttribute("courses", courses);
        return "redirect:/course/allCourse";
    }

    @RequestMapping("/del/{id}")
    public String deleteCourse(@PathVariable("id") int id) {
        courseService.deleteCourseById(id);
        return "redirect:/course/allCourse";
    }

    @RequestMapping("/queryCourse")
    public String queryCourseByName(@RequestParam(name = "name",required = false)String name,
                                  @RequestParam(name="curPage",defaultValue = "1") Integer curPage,
                                  @RequestParam(name = "pageSize",defaultValue = "5")Integer pageSize,
                                  Model model){
        int count = courseService.queryCourseCountByName(name);
        if (count == 0){
            model.addAttribute("error","未查到相关课程");
            model.addAttribute("list",null);
            return "allCourse";
        }
        PaginationDTO paginationDTO = courseService.queryCourseByName(name, curPage, pageSize);
        model.addAttribute("courseName", name);
        model.addAttribute("list",paginationDTO);
        return "allCourse";
    }
    /**
     * 处理图片显示请求
     * @param fileName
     */
    @RequestMapping("/showPic/{fileName}.{suffix}")
    public void showPicture(@PathVariable("fileName") String fileName,
                            @PathVariable("suffix") String suffix,
                            HttpServletResponse response){
        File imgFile = new File(Constants.IMG_PATH + fileName + "." + suffix);
        responseFile(response, imgFile);
    }

    /**
     * 处理图片下载请求
     * @param fileName
     * @param response
     */
    @RequestMapping("/downloadPic/{fileName}.{suffix}")
    public void downloadPicture(@PathVariable("fileName") String fileName,
                                @PathVariable("suffix") String suffix,
                                HttpServletResponse response){
        // 设置下载的响应头信息
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + "headPic.jpg");
        File imgFile = new File(Constants.IMG_PATH + fileName + "." + suffix);
        responseFile(response, imgFile);
    }

    /**
     * 响应输出图片文件
     * @param response
     * @param imgFile
     */
    private void responseFile(HttpServletResponse response, File imgFile) {
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream();){
            byte [] buffer = new byte[1024]; // 图片文件流缓存池
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}