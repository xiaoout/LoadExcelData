package com.lorraine.echelon.fileops;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cchen17 on 8/8/2017.
 */
public class FilesOpsTest {
    @Test
    public void getFileNames() throws Exception {
        FilesOps filesOps = new FilesOps();
        List<String> stringlist = filesOps.getFileNames();
        System.out.println(stringlist);
    }

}