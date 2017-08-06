package com.lorraine.echelon.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/8/6 0006.
 */
public class ExcelInit {
    private static Logger logger = Logger.getLogger("ExcelInit");

    private String filePath;
    private XSSFWorkbook workbook;
    private Sheet sheet;
    private String cell;

    public ExcelInit(String path) {
        this.filePath = path;
    }

    public XSSFWorkbook createExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(this.filePath);
        return checkExcel(workbook) ? workbook : null;
    }

    private boolean checkExcel(XSSFWorkbook workbook) {
        if (workbook == null)
            return false;
        else
            return true;
    }


}
