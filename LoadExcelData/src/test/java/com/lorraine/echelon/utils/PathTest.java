package com.lorraine.echelon.utils;

import org.junit.Test;

import java.util.ResourceBundle;

/**
 * Created by cchen17 on 8/7/2017.
 */
public class PathTest {

    @Test
    public void getPath(){
        ResourceBundle resourceBundle;

        resourceBundle = ResourceBundle.getBundle("ehelon-path");

        System.out.println(resourceBundle.getString("resources.path"));

    }
}
