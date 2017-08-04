package com.code.socket.message;

/**
 * 消息总体
 * Created by 刘长申 on 2017/8/2.
 */
public class ServiceMessage {
    //消息头
    private ServiceHeader header;
    //消息内容
    private ServiceBody body;

    public ServiceMessage() {
    }

    public ServiceMessage(ServiceHeader header) {
        this(header, null);
    }

    public ServiceMessage(ServiceHeader header, ServiceBody body) {
        this.header = header;
        this.body = body;
    }

    public ServiceHeader getHeader() {
        return header;
    }

    public void setHeader(ServiceHeader header) {
        this.header = header;
    }

    public ServiceBody getBody() {
        return body;
    }

    public void setBody(ServiceBody body) {
        this.body = body;
    }
}
