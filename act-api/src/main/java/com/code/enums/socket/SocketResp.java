package com.code.enums.socket;

/**
 * 通讯消息枚举
 * Created by 刘长申 on 2017/8/4.
 */
public enum SocketResp {

    E_2000("2000","调用成功"),

    E_2001("2001","业务调用异常"),

    E_9998("9998","系统异常");

    private String code;
    private String message;

    SocketResp(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
