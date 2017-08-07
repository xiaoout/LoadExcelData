package com.lorraine.echelon.excelops;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class ExcelReader extends ExcelInfo {

    public ExcelReader(String fileName, int sheetNum) throws IOException {
        super(fileName, sheetNum);
    }

    public ExcelReader(String fileName, String sheetName) throws IOException {
        super(fileName, sheetName);
    }

    public XSSFRow getRowByRowNum(int rowNum) {
        return this.getSheet().getRow(rowNum);
    }

    public XSSFCell getCell(int rowNum, int columnNun) {
        return this.getRowByRowNum(rowNum).getCell(columnNun);
    }

    public List<XSSFCell> getColumnByColNum(int columnNum) {
        int rowSize = this.getSheet().getPhysicalNumberOfRows();
        List<XSSFCell> columnCell = new ArrayList<XSSFCell>();
        for (int i = 0; i < rowSize; i++) {
            columnCell.add(getCell(i, columnNum));
        }
        return columnCell;
    }

    public List<String> getRowValues(int rowNum) {
        int rowSize = this.getSheet().getRow(rowNum).getPhysicalNumberOfCells();
        List<String> rowValues = new ArrayList<String>();
        for (int i = 0; i < rowSize; i++)
            rowValues.add(getCell(rowNum,i).getStringCellValue());
        return rowValues;
    }

}
