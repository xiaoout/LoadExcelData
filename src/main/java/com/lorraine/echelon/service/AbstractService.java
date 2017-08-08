package com.lorraine.echelon.service;

import java.io.IOException;

/**
 * Created by cchen17 on 8/7/2017.
 */
public abstract class AbstractService {

    public abstract void readData() throws IOException;
    public abstract void writeData();


}
