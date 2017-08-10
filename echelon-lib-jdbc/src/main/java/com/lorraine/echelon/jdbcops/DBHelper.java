package com.lorraine.echelon.jdbcops;

import java.sql.*;

/**
 * Created by xiaoout on 2017/8/10 0010.
 */
public class DBHelper extends JDBCConfig{

    private PreparedStatement ps;
    private Statement stmt;
    private ResultSet rs;


    public DBHelper() throws SQLException {
        super();
        stmt = this.getConn().createStatement();
    }

    public Connection conn(){
        return super.getConn();
    }

    public String getRow(String sql){
        try {
            rs = stmt.executeQuery(sql);
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close(){
        try {
            super.getConn().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
