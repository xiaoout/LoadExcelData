package com.lorraine.echelon.excelops;

import jdk.nashorn.internal.runtime.ECMAErrors;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by xiaoout on 2017/8/7 0007.
 */
public class ExcelReaderTest {
    @Test
    public void getCell() throws Exception {
        ExcelReader excelReader = new ExcelReader("test.xlsx", 0);
        System.out.println(excelReader.getCell(1, 0));
    }

    @Test
    public void getCellValue() throws Exception {
        ExcelReader excelReader = new ExcelReader("test.xlsx", 0);
        System.out.println(excelReader.getCellValue(1,0));
    }


    @Test
    public void getAllCellValues() throws Exception {
        ExcelReader excelReader = new ExcelReader("test.xlsx", 0);

        excelReader.getAllCellValues();

        System.out.println(excelReader);
    }


}