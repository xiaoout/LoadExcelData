package com.lorraine.echelon.service;

import org.junit.Test;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class ImportExcelServiceTest {

    @Test
    public void writeData() throws Exception {
        String sql_no_eql = "\"insert into gtr_tier1_regular_equation([CalculationTier],[Priority],[ExecCondition1],[ExecCondition2],[SkipCondition],[OutPutItem],[InPutItem],[FileSource],[IndustryCode],[IsDelete]) values(\"&B2&\",\"&A2&\",'\"&D2&\"','\"&E2&\"','\"&H2&\"','\"&F2&\"','\"&G2&\"','\"&C2&\"','V',\"&I2&\")\"";
        ImportExcelService importExcelService = new ImportExcelService("GTR");
        importExcelService.writeData(sql_no_eql);
    }



    @Test
    public void readData() throws Exception {
        ImportExcelService importExcelService = new ImportExcelService("GTR");
        importExcelService.readData();
    }

}