package com.lorraine.echelon.sqlserver.dao;

import com.lorraine.echelon.sqlserver.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by cchen17 on 8/24/2017.
 */
public class ImportDao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public ImportDao() {
    }

    public void insert(String delSql, String sqls) {
        try {
            jdbcTemplate.execute(delSql);
            jdbcTemplate.batchUpdate(sqls);
        } catch (Exception e) {
            throw new RuntimeException("Sqls must be wrong.");
        }
    }

    public List<Map<String, Object>> select(String selSql) {
        try {
            List<Map<String, Object>> list = jdbcTemplate.queryForList(selSql);
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Sqls must be wrong");
        }
    }

}
