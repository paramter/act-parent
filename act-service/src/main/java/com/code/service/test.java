package com.code.service;

import com.code.log.Log4jInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 * Created by 刘长申
 * on time 2017/6/20
 */
public class test {

    public void init(){
        Log4jInit log4jInit = new Log4jInit();
        try {
            log4jInit.afterPropertiesSet();
        }catch (Exception e){
        }
    }

    public static void main(String[] arg){
//        new test().init();
        Logger logger = LoggerFactory.getLogger(test.class);
        logger.debug("测试debug");
    }
}
