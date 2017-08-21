package com.lorraine.echelon.sqlserver.entities;

/**
 * Created by cchen17 on 8/17/2017.
 */
public class Student {
    private String pId;
    private Integer date;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
