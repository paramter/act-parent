//package com.code.bootstrap.pojo;
//
//import com.code.socket.message.ServiceHeader;
//import com.code.socket.message.ServiceMessage;
//import io.netty.channel.ChannelFutureListener;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//
//import java.util.UUID;
//
///**
// * 服务端事件处理
// * Created by 刘长申 on 2017/8/1.
// */
//public class HelloServerHandler extends SimpleChannelInboundHandler<ServiceMessage> {
//
//    protected void messageReceived(ChannelHandlerContext ctx, ServiceMessage msg) throws Exception {
//        System.out.println( ctx.channel().remoteAddress()+" say:"+msg.getContent());
//        //TODO 处理操作
//
//        int version = 1;
//        String sessionId = UUID.randomUUID().toString();
//        String content = "i'm server message";
//
//        ServiceHeader header = new ServiceHeader(version, content.length(), sessionId);
//        ServiceMessage message = new ServiceMessage(content);
//        message.setServiceHeader(header);
//        //回写消息并关闭连接
//        ctx.writeAndFlush(message).addListener(ChannelFutureListener.CLOSE);
////        ctx.channel().closeFuture().addListener(ChannelFutureListener.CLOSE);
//    }
//
//    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ServiceMessage serviceMessage) throws Exception {
//
//    }
//}
