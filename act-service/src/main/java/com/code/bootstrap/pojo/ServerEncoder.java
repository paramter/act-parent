package com.code.bootstrap.pojo;

import com.code.socket.message.ServiceHeader;
import com.code.socket.message.ServiceMessage;
import com.code.util.json.JsonSerializableUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务端编码器
 * Created by 刘长申 on 2017/8/2.
 */
public class ServerEncoder extends MessageToByteEncoder<ServiceMessage> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void encode(ChannelHandlerContext channelHandlerContext, ServiceMessage serviceMessage, ByteBuf byteBuf) throws Exception {
//        logger.debug("开始编码:{}",serviceMessage.getContent());
//        ServiceHeader header = serviceMessage.getServiceHeader();
//        byteBuf.writeInt(header.getVersion());
//        byteBuf.writeInt(header.getContentLength());
//        byteBuf.writeBytes(header.getSessionId().getBytes());

        byteBuf.writeBytes(JsonSerializableUtil.bean2Json(serviceMessage).getBytes());
    }
}
