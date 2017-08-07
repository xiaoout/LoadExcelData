package com.lorraine.echelon.excelops;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;
import java.util.List;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class ExcelInfo extends ExcelConstructor {

    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;
    private List<XSSFCell> column;

    public ExcelInfo(String fileName, int sheetNum) throws IOException {
        super(fileName);
        this.sheet = this.getWorkbook().getSheetAt(sheetNum);
    }

    public ExcelInfo(String fileName, String sheetName) throws IOException {
        super(fileName);
        this.sheet = this.getWorkbook().getSheet(sheetName);
    }

    public XSSFSheet getSheet() {
        return sheet;
    }
}
