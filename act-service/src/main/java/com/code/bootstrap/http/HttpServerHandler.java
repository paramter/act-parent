package com.code.bootstrap.http;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import com.code.bootstrap.common.HttpRespUtil;
import com.code.socket.message.ServiceHeader;
import com.code.socket.message.ServiceMessage;
import com.code.util.json.JsonSerializableUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * http服务处理
 * Created by 刘长申 on 2017/8/3.
 */
public class HttpServerHandler extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.debug("接受消息.{}",msg);
        String serviceId = null;
        if(msg instanceof HttpRequest){
            HttpRequest request = (HttpRequest)msg;
            String uri = request.getUri();
           serviceId = uri.substring(1);
            logger.debug("请求客户端uri:{},ServiceId:{}",uri,serviceId);
        }
        if(msg instanceof HttpContent){
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();

            logger.debug("请求客户端内容:{}",buf.toString(CharsetUtil.UTF_8));
            ServiceMessage message = JsonSerializableUtil.readValue(buf.toString(CharsetUtil.UTF_8), ServiceMessage.class);
            buf.release();

            //返回信息 TODO 由业务处理类返回
            Object object = new Object();
            FullHttpResponse response = HttpRespUtil.sucMessage(object);
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("报文接收异常,msg:{}",cause);
        //异常报文返回
        FullHttpResponse response = HttpRespUtil.errMessage(cause.getMessage(), true);
        ctx.writeAndFlush(response);
        ctx.close();
    }

    public static void main(String[] arg){
        String str = "/ceshi";
        String serviceId = str.substring(1);
        System.out.println(serviceId);
    }
}
