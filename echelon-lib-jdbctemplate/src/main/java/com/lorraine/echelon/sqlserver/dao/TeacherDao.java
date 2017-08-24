package com.lorraine.echelon.sqlserver.dao;

import com.lorraine.echelon.sqlserver.entities.Student;
import com.lorraine.echelon.sqlserver.mapper.StudentMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by cchen17 on 8/22/2017.
 */
public class TeacherDao implements Dao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void create(String name, Integer age) {

    }

    public Student getStudent(Integer id) {
        return null;
    }

    public List<Student> listStudents() {
        String sql = "select top 10 * from mart.dbo.Dividend_delta";
        List<Student> students = jdbcTemplate.query(sql,new StudentMapper());
        return students;
    }


}
