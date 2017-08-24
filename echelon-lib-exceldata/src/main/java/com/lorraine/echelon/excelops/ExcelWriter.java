package com.lorraine.echelon.excelops;

import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.IOException;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class ExcelWriter extends ExcelInfo {

    public ExcelWriter(String dir, String fileName, int sheetNum) throws IOException {
        super(dir, fileName, sheetNum);
    }


    public void setValue(int rowNo, int colNo, String value) {
        //TODO: to transfer String to Object
        XSSFCell cell = this.getSheet().getRow(rowNo).createCell(colNo);
        cell.setCellValue(value);
    }

    public void setFormula(int rowNo,int colNo, String formula){
        XSSFCell cell = this.getSheet().getRow(rowNo).createCell(colNo);
        cell.setCellFormula(formula);
    }

}
