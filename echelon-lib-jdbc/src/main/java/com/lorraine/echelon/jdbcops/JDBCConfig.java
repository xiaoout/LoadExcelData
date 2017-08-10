package com.lorraine.echelon.jdbcops;

import com.lorraine.echelon.statics.DBConfigs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xiaoout on 2017/8/10 0010.
 */
public class JDBCConfig {
    private String driverName = DBConfigs.Driver_Name;
    private String dbServer = DBConfigs.DB_URL;
    private String user = DBConfigs.User;
    private String pass = DBConfigs.pass;
    private Connection conn;

    public JDBCConfig() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databasename=HRSYS", user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
