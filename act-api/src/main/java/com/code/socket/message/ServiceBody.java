package com.code.socket.message;

import com.code.enums.socket.SocketResp;

/**
 * 消息响应内容
 * Created by 刘长申 on 2017/8/4.
 */
public class ServiceBody {
    /**
     * 响应码
     */
    private String code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应内容
     */
    private Object content;

    public ServiceBody() {
        //默认为成功
        this(SocketResp.E_2000.getCode(),SocketResp.E_2000.getMessage());
    }

    public ServiceBody(String code, String message) {
        this(code, message,null);
    }

    public ServiceBody(String code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
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

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
