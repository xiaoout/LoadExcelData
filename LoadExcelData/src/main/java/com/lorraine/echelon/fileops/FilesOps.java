package com.lorraine.echelon.fileops;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cchen17 on 8/8/2017.
 */
public class FilesOps extends FileConfigs {

    private String directoryName;

    public List<File> getFiles() {
        File directory = new File(this.RootPath);
        if (directory.isDirectory() && directory.exists()) {
            List<File> fileList = new ArrayList<File>(Arrays.asList(directory.listFiles()));
            return fileList;
        } else {
            System.out.println("It's not a directory.");
            return null;
        }
    }

    public List<String> getFileNames() {
        List<File> files = getFiles();
        List<String> fileNames = new ArrayList<String>();
        //TODO: Java8
        for (int i = 0; i < files.size(); i++) {
            fileNames.add(files.get(i).getName());
        }
        return fileNames;
    }


}
