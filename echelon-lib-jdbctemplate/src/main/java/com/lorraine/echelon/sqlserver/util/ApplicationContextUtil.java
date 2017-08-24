package com.lorraine.echelon.sqlserver.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cchen17 on 8/22/2017.
 */
public class ApplicationContextUtil {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("application-beans.xml");

    public static Object getBean(String name) throws BeansException {
        return context.getBean(name);
    }

}
