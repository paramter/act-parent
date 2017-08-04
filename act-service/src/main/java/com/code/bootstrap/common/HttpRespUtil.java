package com.code.bootstrap.common;

import com.code.constants.common.Constants;
import com.code.enums.socket.SocketResp;
import com.code.socket.message.ServiceBody;
import com.code.socket.message.ServiceHeader;
import com.code.socket.message.ServiceMessage;
import com.code.util.common.CommonUtil;
import com.code.util.json.JsonSerializableUtil;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * 接口返回内容
 * Created by 刘长申 on 2017/8/4.
 */
public class HttpRespUtil {

    /**
     * 整理异常返回.
     * @param respJson 返回json
     * @return FullHttpResponse
     */
    private static FullHttpResponse httpResp(String respJson) {
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
                Unpooled.wrappedBuffer(respJson.getBytes()));
        setDefaultType(response);
        return response;
    }

    /**
     * 成功返回信息
     * @param jsonContent 返回业务bean
     * @return sucJson
     */
    public static FullHttpResponse sucMessage(Object jsonContent){
        ServiceBody body = new ServiceBody(SocketResp.E_2000.getCode(), SocketResp.E_2000.getMessage());
        body.setContent(jsonContent);
        String respJson = commonRespMessage(body);
        return httpResp(respJson);
    }

    /**
     * 异常返回信息.
     * @param errorMsg 异常信息
     * @param isSystem 是否是系统异常
     * @return errJson
     */
    public static FullHttpResponse errMessage(final String errorMsg, boolean isSystem) {
        ServiceBody body = null;
        if(isSystem) {
            body = new ServiceBody(SocketResp.E_9998.getCode(), errorMsg);
        }else{
            body = new ServiceBody(SocketResp.E_2001.getCode(), errorMsg);
        }
        String respJson = commonRespMessage(body);
        return httpResp(respJson);
    }

    private static String commonRespMessage(ServiceBody body){
        String bodyJson = JsonSerializableUtil.bean2Json(body);
        ServiceHeader header = new ServiceHeader(Constants.DEFAULT_VERSION,
                bodyJson.length(), CommonUtil.getUUID());
        ServiceMessage serviceMessage = new ServiceMessage(header, body);
        return JsonSerializableUtil.bean2Json(serviceMessage);
    }

    /**
     * 返回response属性设置
     * @param response
     */
    public static void setDefaultType(FullHttpResponse response){
        response.headers().set(CONTENT_TYPE, "application/json; charset=utf-8");
        response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
        response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
    }
}
