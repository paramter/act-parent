package com.code.redis.manager.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring容器加载
 * Created by 刘长申
 * on time 2017/5/19
 */
public class SpringContentLoader {
    private static ApplicationContext classPathXmlApplicationContext = null;

    public static void readXml(String xmlName){
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(xmlName);
    }

    public static Object getBean(String xmlName,String beanId){
        readXml(xmlName);
        return classPathXmlApplicationContext.getBean(beanId);
    }
}
