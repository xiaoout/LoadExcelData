package com.lorraine.echelon.sqlserver.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by cchen17 on 8/24/2017.
 */
public class ImportDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDs(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public void insert(String delSql ,String sqls) {
        try {
            jdbcTemplate.execute(delSql);
            jdbcTemplate.batchUpdate(sqls);
        } catch (Exception e) {
            throw new RuntimeException("Sqls must be wrong.");
        }
    }
}
