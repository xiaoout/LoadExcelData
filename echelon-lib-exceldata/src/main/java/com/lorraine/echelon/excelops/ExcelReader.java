package com.lorraine.echelon.excelops;

import org.apache.poi.ss.usermodel.CellType;
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

    public XSSFRow getRowByRowNo(int rowNo) {
        return this.getSheet().getRow(rowNo);
    }

    public XSSFCell getCell(int rowNo, int columnNo) {
        return this.getRowByRowNo(rowNo).getCell(columnNo);
    }

    public List<XSSFCell> getColumnByColNum(int columnNum) {
        int rowSize = this.getSheet().getPhysicalNumberOfRows();
        List<XSSFCell> columnCell = new ArrayList<XSSFCell>();
        for (int i = 0; i < rowSize; i++) {
            columnCell.add(getCell(i, columnNum));
        }
        return columnCell;
    }

    public List<String> getRowValues(int rowNo) {
        int colSize = this.getSheet().getRow(rowNo).getPhysicalNumberOfCells();
        List<String> rowValues = new ArrayList<String>();
        for (int i = 0; i < colSize; i++)
            rowValues.add(getCellValue(rowNo, i));
        return rowValues;
    }

    public List<String> getColumnValues(int colNo) {
        int rowSize = this.getSheet().getPhysicalNumberOfRows();
        List<String> colValues = new ArrayList<String>();
        for (int i = 0; i < rowSize; i++)
            colValues.add(getCellValue(i, colNo));
        return colValues;
    }

    public String getCellValue(int rowNo, int columnNo) {
        XSSFCell cell = getCell(rowNo, columnNo);
        if (cell.getCellTypeEnum() == CellType.STRING) {
            return cell.getStringCellValue();
        } else
            return Double.toString(cell.getNumericCellValue());
    }

    public String[][] getAllCellValues() {
        //TODO: to set array boundary
        String[][] allValues = new String[100][100];

        int rowSize = this.getSheet().getPhysicalNumberOfRows();

        for (int i = 0; i < rowSize; i++) {
            int colSize = this.getSheet().getRow(i).getPhysicalNumberOfCells();
            for (int j = 0; j < colSize; j++) {
                allValues[i][j] = getCellValue(i, j);
            }
        }

        return allValues;
    }

}
