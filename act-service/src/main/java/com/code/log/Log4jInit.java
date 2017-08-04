package com.code.log;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.InitializingBean;

/**
 * 日志文件初始化
 * Created by 刘长申
 * on time 2017/6/13
 */
public class Log4jInit implements InitializingBean {

    /**
     * 加载log4j.properties文件
     */
    public void initLog4j(){
        PropertyConfigurator.configure("log4j.properties");
    }

    public void afterPropertiesSet() throws Exception {
        initLog4j();
    }
}
