package com.lorraine.echelon.service;

import com.lorraine.echelon.excelops.ExcelReader;
import com.lorraine.echelon.excelops.ExcelWriter;
import com.lorraine.echelon.fileops.FilesOps;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class ImportExcelService extends AbstractService {

    private ExcelReader excelReader;
    private ExcelWriter excelWriter;
    private FilesOps filesOps;
    private String dir = "GTR";

    //TODO: the path is redundancy
    public ImportExcelService() {
        filesOps = new FilesOps();
    }

    public ImportExcelService(String dir) {
        filesOps = new FilesOps(dir);
    }

    public HashMap<String, List<String>> readData1() throws IOException {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        List<String> fileNames = filesOps.getFileNames();
        for (String fileName : fileNames) {
            excelReader = new ExcelReader(dir, fileName, 0);

            int colSize = excelReader.getSheet().getRow(0).getPhysicalNumberOfCells();
            List<String> list = excelReader.getColumnFormularValues(colSize);
            map.put(fileName, list);
            excelReader.getWorkbook().close();
        }
        return map;
    }


    public void writeData(String sql_no_eql) throws IOException {
        List<String> fileNames = filesOps.getFileNames();
        for (String fileName : fileNames) {
            excelWriter = new ExcelWriter(dir, fileName, 0);
            int colSize = excelWriter.getSheet().getRow(0).getPhysicalNumberOfCells();
            int rowSize = excelWriter.getSheet().getPhysicalNumberOfRows();

            for (int i = 1; i < rowSize; i++)
                excelWriter.setFormula(i, colSize, sql_no_eql_byOrder(sql_no_eql,i+1));

            excelWriter.getWorkbook().write(new FileOutputStream(excelWriter.getPath()));
            excelWriter.getWorkbook().close();
        }
    }

    private String sql_no_eql_byOrder(String str, int i) {
        String str_start = str.substring(0,str.indexOf("values"));
        String str_end = str.substring(str.indexOf("values")).replaceAll("2",String.valueOf(i));

        return str_start+str_end;

//        return str.replaceAll("2",String.valueOf(i));
    }

    @Override
    public void readData() throws IOException {

    }

    @Override
    public void writeData() throws IOException {

    }
}
