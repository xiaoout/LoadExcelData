package com.lorraine.echelon.service.importteam;

import com.lorraine.echelon.excelops.ExcelReader;
import com.lorraine.echelon.excelops.ExcelWriter;
import com.lorraine.echelon.service.AbstractService;
import com.lorraine.echelon.service.ImportExcelService;
import com.lorraine.echelon.service.importteam.entities.ImportEntity;
import com.lorraine.echelon.sqlserver.dao.ImportDao;
import com.lorraine.echelon.sqlserver.util.ApplicationContextUtil;
import org.junit.FixMethodOrder;

import javax.management.RuntimeErrorException;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by cchen17 on 8/24/2017.
 */
public class ImportService extends AbstractService {

    private ImportExcelService service;
    private String delSqls = "";
    private String sql_no_eql = "\"insert into gtr_tier1_regular_equation([CalculationTier],[Priority],[ExecCondition1],[ExecCondition2],[SkipCondition],[OutPutItem],[InPutItem],[FileSource],[IndustryCode],[IsDelete]) values(\"&B2&\",\"&A2&\",'\"&D2&\"','\"&E2&\"','\"&H2&\"','\"&F2&\"','\"&G2&\"','\"&C2&\"','V',\"&I2&\")\"";
    private String dirName = "GTR";
    private String savePath1 = "D:\\";
    private String savePath2 = "";
    private String savePath3 = "";
    private ImportEntity entity;

    public ImportService() throws IOException {
        service = new ImportExcelService(dirName);
        entity = new ImportEntity();
    }

    public void writeData() throws IOException {
        //write formular into excel
        service.writeData(sql_no_eql);
    }

    public void readData() throws IOException {
        //read formular
        entity.setMap(service.readData1());
    }

    public void contentOp() {
        //save into 3 files and run in DB
        HashMap<String, List<String>> map = entity.getMap();
        for(String fileName : map.keySet()){
            String content = getContent(map.get(fileName));

            fileName = fileName.substring(0,fileName.indexOf('.')) + ".sql";

            String path1 = savePath1 + fileName;
            String path2 = savePath2 + fileName;
            String path3 = savePath3 + fileName;

            saveFile(path1,content);
            runInDB(delSqls,content);

        }

    }

    private String getContent(List<String> list){
        return list.stream().collect(Collectors.joining("\n"));
    }

    public void saveFile(String path, String content) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("The file something errors!");
        }

        synchronized (file) {
            try {
                FileWriter fw = new FileWriter(path);
                fw.write(content);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void runInDB(String delSqls, String content) {
        ImportDao importDao = (ImportDao) ApplicationContextUtil.getBean("ImportDao");
        String selSql = "select top 2 * from mart.dbo.Dividend";
        importDao.select(selSql);
    }
}
