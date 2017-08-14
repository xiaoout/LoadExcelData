package com.lorraine.echelon.jdbcops;

import com.lorraine.echelon.statics.SqlQuery;
import org.junit.Test;

import java.util.List;

/**
 * Created by xiaoout on 2017/8/10 0010.
 */
public class DBHelperTest {

    @Test
    public void getRow_cchen17() throws Exception {
        DBHelper dbHelper = new DBHelper();
        List<Object> list = dbHelper.getRow(SqlQuery.cchen17_SelectTest,1);
        System.out.println(list);
        dbHelper.close();
    }

    @Test
    public void getColunm_cchen17() throws Exception {
        DBHelper dbHelper = new DBHelper();
        List<Object> list1 = dbHelper.getColunm(SqlQuery.cchen17_SelectTest,1);
        System.out.println(list1);
        dbHelper.close();
    }


        @Test
    public void getColunm_xiaoout() throws Exception {
        DBHelper dbHelper = new DBHelper();
        List<Object> list = dbHelper.getColunm(SqlQuery.xiaout_SelectTest,1);
        System.out.println(list);
        dbHelper.close();
    }

    @Test
    public void getRow_xiaoout() throws Exception {
        DBHelper dbHelper = new DBHelper();
        List<Object> list = dbHelper.getRow(SqlQuery.xiaout_SelectTest,1);
        System.out.println(list);
        List<Object> list1 = dbHelper.getColunm(SqlQuery.xiaout_SelectTest,1);
        System.out.println(list1);
        dbHelper.close();
    }



}