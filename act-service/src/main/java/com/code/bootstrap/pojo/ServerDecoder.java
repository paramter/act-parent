//package com.code.bootstrap.pojo;
//
//import com.code.socket.message.ServiceHeader;
//import com.code.socket.message.ServiceMessage;
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.handler.codec.ByteToMessageDecoder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
///**
// * 服务解码器
// * Created by 刘长申 on 2017/8/2.
// */
//public class ServerDecoder extends ByteToMessageDecoder{
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
////        //获取版本号
////        int version = byteBuf.readInt();
////        //获取消息长度
////        int contentLength = byteBuf.readInt();
////        //获取sessionId
////        byte[] sessionByte = new byte[36];
////        byteBuf.readBytes(sessionByte);
////        String sessionId = new String(sessionByte);
////        ServiceHeader serviceHeader = new ServiceHeader(version,contentLength,sessionId);
////        logger.debug("消息头,版本号:{},消息长度:{},sessionid:{}",version,contentLength,sessionId);
//
//        // 读取消息内容
//        byte[] content = byteBuf.readBytes(byteBuf.readableBytes()).array();
//        logger.debug("消息内容:{}",new String(content));
//        ServiceMessage message = new ServiceMessage( new String(content));
//        list.add(message);
//    }
//}
