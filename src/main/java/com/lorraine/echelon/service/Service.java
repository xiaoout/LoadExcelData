package com.lorraine.echelon.service;

import java.util.ResourceBundle;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class Service extends AbstractService {
    private static final String RootPath = ResourceBundle
            .getBundle("ehelon-path")
            .getString("resources.path");

    private String path ;

    public Service(String fileName){
        this.path = RootPath + fileName;
    }

    public void readData() {

    }

    public void writeData() {

    }
}
