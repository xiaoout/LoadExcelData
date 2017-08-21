import com.lorraine.echelon.sqlserver.dao.StudentDao;
import com.lorraine.echelon.sqlserver.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by cchen17 on 8/17/2017.
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-beans.xml");

        StudentDao studentDao = (StudentDao) context.getBean("StudentDao");
        List<Student> students = studentDao.listStudents();

        for(Student stu : students){
            System.out.println(stu.getpId() +" " + stu.getDate());
        }
    }
}
