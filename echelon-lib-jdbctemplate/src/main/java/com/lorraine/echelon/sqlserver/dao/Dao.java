package com.lorraine.echelon.sqlserver.dao;

import com.lorraine.echelon.sqlserver.entities.Student;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by cchen17 on 8/17/2017.
 */
public interface Dao {
    /**
     * This is the method to be used to initialize database resources ie.
     * connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create a record in the Student table.
     */
    public void create(String name, Integer age);

    public Student getStudent(Integer id);

    /**
     * This is the method to be used to list down all the records from the
     * Student table.
     */
    public List<Student> listStudents();
}
