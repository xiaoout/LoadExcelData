package com.lorraine.echelon.statics;

import java.util.ResourceBundle;

/**
 * Created by xiaoout on 2017/8/10 0010.
 */
public class DBConfigs {
    public final static String Driver_Name = ResourceBundle.getBundle("Config-echelon-lib-jdbc-sqlserver").getString("jdbc_driver");
    public final static String DB_URL = ResourceBundle.getBundle("Config-echelon-lib-jdbc-sqlserver").getString("db_server");
    public final static String User = ResourceBundle.getBundle("Config-echelon-lib-jdbc-sqlserver").getString("user");
    public final static String pass = ResourceBundle.getBundle("Config-echelon-lib-jdbc-sqlserver").getString("pass");

}
