package com.lorraine.echelon.sqlserver.dao;

import com.lorraine.echelon.sqlserver.entities.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by cchen17 on 8/17/2017.
 */
public class StudentDaoTest {
    @Test
    public void listStudents() throws Exception {
        String str = this.getClass().getResource("/").getPath().split("target")[0];
        String str1 = "src/main/java/";
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-beans.xml");

        StudentDao studentDao = (StudentDao) context.getBean("StudentDao");
        List<Student> students = studentDao.listStudents();

        for(Student stu : students){
            System.out.println(stu.getpId() +" " + stu.getDate());
        }
    }

    @Test
    public void tes(){
        String str = this.getClass().getResource("/").getPath().split("target")[0];
        String str1 = "src/main/java/";
        System.out.println(str+str1);
    }

}