package com.lorraine.echelon.service;

import com.lorraine.echelon.excelops.ExcelReader;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class Service extends AbstractService {

    private ExcelReader excelReader;

    public Service(String fileName,int sheetNo) throws IOException {
        excelReader = new ExcelReader(fileName,sheetNo);
    }

    public void readData() {
        
    }

    public void writeData() {

    }
}
