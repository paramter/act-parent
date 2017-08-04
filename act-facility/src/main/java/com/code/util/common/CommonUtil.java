package com.code.util.common;

import java.util.UUID;

/**
 * 公共方法
 * Created by 刘长申 on 2017/8/4.
 */
public class CommonUtil {

    /**
     * 获取uuid
     * @return uuid
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
