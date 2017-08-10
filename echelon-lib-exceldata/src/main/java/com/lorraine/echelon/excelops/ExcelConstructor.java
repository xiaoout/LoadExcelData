package com.lorraine.echelon.excelops;

import com.lorraine.echelon.statics.PathConst;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class ExcelConstructor {
    private static final String RootPath = PathConst.directoryPath;

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
        InputStream inputStream = new FileInputStream(path);

        return new XSSFWorkbook(inputStream);
    }

}
