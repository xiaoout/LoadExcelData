package com.lorraine.echelon.excelops;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class ExcelConstructor {
    private static final String RootPath = ResourceBundle
            .getBundle("ehelon-path")
            .getString("resources.path");

    private String path;
    private final XSSFWorkbook workbook;


    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    public ExcelConstructor(String fileName) throws IOException {
        this.path = RootPath + fileName;
        this.workbook = createWorkBook();
    }

    public XSSFWorkbook createWorkBook() throws IOException {
        return new XSSFWorkbook(this.path);
    }

}
