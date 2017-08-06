package com.lorraine.echelon.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class ExcelUtil extends ExcelInit{
    private XSSFWorkbook workbook;
    private Sheet sheet;
    private Row row;
    private String fileName;


    public ExcelUtil(String path) {
        super(path);
    }

    @Override
    public XSSFWorkbook createExcel() throws IOException {
        this.workbook = super.createExcel();
        return this.workbook;
    }

    public Sheet getSheetByNum(int num){
        sheet = workbook.getSheetAt(num);
        return sheet;
    }

    public Row getRowByNum(int num){
        row = sheet.getRow(num);
        return row;
    }

}
