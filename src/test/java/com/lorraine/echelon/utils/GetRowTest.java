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
    public void getpath() {

        resourceBundle = ResourceBundle.getBundle("ehelon-path");

        System.out.println(resourceBundle.getString("resources.path"));

    }

}
