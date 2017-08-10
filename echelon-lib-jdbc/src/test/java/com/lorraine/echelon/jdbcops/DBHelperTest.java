package com.lorraine.echelon.jdbcops;

import org.junit.Test;

/**
 * Created by xiaoout on 2017/8/10 0010.
 */
public class DBHelperTest {
    @Test
    public void getRow() throws Exception {
        DBHelper dbHelper = new DBHelper();
        String str = dbHelper.getRow("select * from User_Login");
        System.out.println(str);
        dbHelper.close();
    }

}