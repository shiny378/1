import com.itheima.dto.PaginationDTO;
import com.itheima.pojo.Courses;
import com.itheima.service.CourseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @version : V1.0
 * @ClassName: MyTest
 * @Description: TODO
 * @Auther: wangqiang
 * @Date: 2020/2/19 17:41
 */
public class MyTest {
    @Test
    public  void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseServiceImpl = context.getBean("CourseServiceImpl", CourseService.class);
        PaginationDTO paginationDTO = courseServiceImpl.queryCourseByName("", 0, 3);
        List<Courses> courses = paginationDTO.getData();
        for (Courses course : courses) {
            System.out.println(course);
        }
    }
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseServiceImpl = context.getBean("CourseServiceImpl", CourseService.class);
        int count = courseServiceImpl.queryCourseCountByName("");
        System.out.println(count);
    }
}