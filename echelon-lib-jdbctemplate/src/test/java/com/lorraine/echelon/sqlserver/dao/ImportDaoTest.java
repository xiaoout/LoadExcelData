package com.lorraine.echelon.sqlserver.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by cchen17 on 8/25/2017.
 */
public class ImportDaoTest {
    @Test
    public void select() throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-beans.xml");
        ImportDao importDao = (ImportDao) context.getBean("ImportDao");
        String selSql = "select top 2 * from MEDS.dbo.company_migrate_log";
        List<Map<String, Object>> list = importDao.select(selSql);
        System.out.println(list);
    }

}