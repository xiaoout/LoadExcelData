package com.lorraine.echelon.service.importteam;

import com.lorraine.echelon.service.ImportExcelService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by cchen17 on 8/24/2017.
 */
public class ImportServiceTest {
    ImportService service;

    @Before
    public void setService() throws IOException {
        service = new ImportService();
    }

    @Test
    public void runInDB() {
    }

    @Test
    public void writeData() throws IOException {
        service.writeData();
    }

    @Test
    public void readData() throws IOException {
        service.readData();
    }

    @Test
    public void iT() throws IOException {
        service.writeData();
        service.readData();
        service.contentOp();

    }
}