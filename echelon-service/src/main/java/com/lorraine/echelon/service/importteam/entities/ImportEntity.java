package com.lorraine.echelon.service.importteam.entities;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cchen17 on 8/24/2017.
 */
public class ImportEntity {

    private HashMap<String ,List<String>> map;

    public HashMap<String, List<String>> getMap() {
        return map;
    }

    public void setMap(HashMap<String, List<String>> map) {
        this.map = map;
    }
}
