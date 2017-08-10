package com.lorraine.echelon.service;

import com.lorraine.echelon.excelops.ExcelReader;
import com.lorraine.echelon.fileops.FilesOps;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class Service extends AbstractService {

    private ExcelReader excelReader;
    private FilesOps filesOps;

    //TODO: the path is redundancy
    public Service() throws IOException {
        filesOps = new FilesOps();
    }

    public void readData() throws IOException {
        List<String> fileNames = filesOps.getFileNames();
        for (String fileName : fileNames) {
            excelReader = new ExcelReader(fileName, 0);
            System.out.println(excelReader.getRowValues(0));
        }
    }

    public void writeData() {

    }
}
