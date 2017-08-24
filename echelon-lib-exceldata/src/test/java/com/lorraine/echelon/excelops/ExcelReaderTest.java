package com.lorraine.echelon.excelops;

import org.junit.Test;

/**
 * Created by xiaoout on 2017/8/7 0007.
 */
public class ExcelReaderTest {
    @Test
    public void getFormularValue() throws Exception {
        ExcelReader excelReader = new ExcelReader("GTR", "qq.xlsx",0);
        System.out.println(excelReader.getFormularValue(1,9));
    }

    @Test
    public void getRowValues() throws Exception {
        ExcelReader excelReader = new ExcelReader("test.xlsx", 0);
        System.out.println(excelReader.getRowValues(0));
        System.out.println(excelReader.getRowValues(1));
        System.out.println(excelReader.getRowValues(2));
    }

    @Test
    public void getColumnValues() throws Exception {
        ExcelReader excelReader = new ExcelReader("test.xlsx", 0);
        System.out.println(excelReader.getColumnValues(0));
        System.out.println(excelReader.getColumnValues(1));
        System.out.println(excelReader.getColumnValues(2));
    }

    @Test
    public void getColumnValuesWithDir() throws Exception {
        ExcelReader excelReader = new ExcelReader("GTR", "GTR_V_Tier_Equations.xlsx",0);
        System.out.println(excelReader.getColumnValues(0));
        System.out.println(excelReader.getColumnValues(1));
        System.out.println(excelReader.getColumnValues(2));
    }



    @Test
    public void getCell() throws Exception {
        ExcelReader excelReader = new ExcelReader("test.xlsx", 0);
        System.out.println(excelReader.getCell(1, 0));
    }

    @Test
    public void getCellValue() throws Exception {
        ExcelReader excelReader = new ExcelReader("test.xlsx", 0);
        System.out.println(excelReader.getCellValue(2,0));
        System.out.println(excelReader.getCellValue(1,0));
    }


    @Test
    public void getAllCellValues() throws Exception {
        ExcelReader excelReader = new ExcelReader("test.xlsx", 0);

        String[][] str = excelReader.getAllCellValues();

        for(int i = 0 ;i < 3 ; i++)
            for(int j = 0 ; j < 3 ; j++)
                System.out.println(str[i][j]);
    }


}