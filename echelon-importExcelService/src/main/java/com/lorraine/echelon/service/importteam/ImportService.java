package com.lorraine.echelon.service.importteam;

import com.lorraine.echelon.service.AbstractService;
import com.lorraine.echelon.service.ImportExcelService;
import com.lorraine.echelon.service.importteam.entities.ImportEntity;
import com.lorraine.echelon.sqlserver.dao.ImportDao;
import com.lorraine.echelon.sqlserver.util.ApplicationContextUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    public void service(){
        writeData();
        readData();
        contentOp();
    }

    public void writeData() {
        //write formular into excel
        try {
            service.writeData(sql_no_eql);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData(){
        //read formular
        try {
            entity.setMap(service.readData1());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contentOp() {
        //save into 3 files and run in DB
        HashMap<String, List<String>> map = entity.getMap();
        for (String fileName : map.keySet()) {
            String content = getContent(map.get(fileName));

            String tableName = fileName.substring(0, fileName.indexOf('.'));
            fileName = tableName + ".sql";

            String path1 = savePath1 + fileName;
            String path2 = savePath2 + fileName;
            String path3 = savePath3 + fileName;

            saveFile(path1, content);
//            saveFile(path2, content);
//            saveFile(path3, content);
            runInDB(tableName, content);
        }

    }

    private String getContent(List<String> list) {
        return list.stream().collect(Collectors.joining("\n"));
    }

    private void saveFile(String path, String content) {
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

    private void runInDB(String tableName, String sqlContents) {
        ImportDao importDao = (ImportDao) ApplicationContextUtil.getBean("ImportDao");
        String setOn = "SET IDENTITY_INSERT MEDS.dbo." + tableName + " ON";
        String setOff = "SET IDENTITY_INSERT MEDS.dbo." + tableName + " OFF";
        //String delSql = "delete from MEDS.dbo." + tableName;

        importDao.insert(setOn, sqlContents, setOff);
    }
}
