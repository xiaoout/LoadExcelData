package com.lorraine.echelon.sqlserver.mapper;

import com.lorraine.echelon.sqlserver.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cchen17 on 8/17/2017.
 */
public class StudentMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setDate(rs.getInt("ExcludingDate"));
        student.setpId(rs.getString("PerformanceId"));
        return student;
    }
}
