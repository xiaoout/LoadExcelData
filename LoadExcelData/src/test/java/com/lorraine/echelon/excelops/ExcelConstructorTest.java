package com.lorraine.echelon.excelops;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class ExcelConstructorTest {

    @Test
    public void getWorkbook() throws IOException {
        ExcelConstructor constructor = new ExcelConstructor("test.xlsx");
        XSSFWorkbook workbook = constructor.getWorkbook();
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(1);
        System.out.println(cell.getStringCellValue());
    }
}