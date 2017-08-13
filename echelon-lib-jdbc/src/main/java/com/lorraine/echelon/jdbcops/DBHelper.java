package com.lorraine.echelon.jdbcops;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoout on 2017/8/10 0010.
 */
public class DBHelper extends JDBCConfig {

    private PreparedStatement ps;
    private Statement stmt;
    private ResultSet rs;


    public DBHelper() throws SQLException {
        super();
        stmt = this.getConn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }


    public Connection conn() {
        return super.getConn();
    }

    public ResultSet getRs() {
        return rs;
    }

    public List<Object> getRow(String sql, int rowNo) {
        try {
            List<Object> list = new ArrayList<Object>();
            rs = stmt.executeQuery(sql);
            int size = rs.getMetaData().getColumnCount();
            rs.absolute(rowNo);
            for (int i = 1; i <= size; i++) {
                list.add(rs.getObject(i));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Object> getColunm(String sql, int colNo) {
        try {
            List<Object> list = new ArrayList<Object>();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getObject(colNo));
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void close() {
        try {
            super.getConn().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
