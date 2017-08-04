package com.code.socket.message;

/**
 * 消息头
 * Created by 刘长申 on 2017/8/2.
 */
public class ServiceHeader {
    //协议版本
    private int version;
    //消息内容长度
    private int contentLength;
    //服务id
    private String sessionId;

    public ServiceHeader() {
    }

    public ServiceHeader(int version, int contentLength, String sessionId) {
        this.version = version;
        this.contentLength = contentLength;
        this.sessionId = sessionId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
