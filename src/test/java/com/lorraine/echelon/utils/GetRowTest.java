package com.lorraine.echelon.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by xiaoout on 2017/8/7 0007.
 */
public class GetRowTest {
    ResourceBundle resourceBundle;

    @Before
    public void getpath(){

        resourceBundle = ResourceBundle.getBundle("ehelon-path");

        System.out.println(resourceBundle.getString("resources.path"));

    }

    @Test
    public void getRow() throws IOException {
        String path = this.getClass().getResource("/").getPath().toString().split("target")[0].toString();
//        path = path + "src/main/resources/test.xlsx";
        path = resourceBundle.getString("resources.path") + "test.xlsx";
        System.out.println(path);
        Workbook workbook = new XSSFWorkbook(path);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        System.out.println(row.getCell(1));
    }
}
