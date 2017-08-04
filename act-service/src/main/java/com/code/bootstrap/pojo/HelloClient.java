//package com.code.bootstrap.pojo;
//
//import com.code.socket.message.ServiceHeader;
//import com.code.socket.message.ServiceMessage;
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.Channel;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioSocketChannel;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.UUID;
//
///**
// * netty客户端
// * Created by 刘长申 on 2017/8/1.
// */
//public class HelloClient {
//    private static final String HOST = "127.0.0.1";
//    private static final int PORT = 7879;
//
//    public static void main(String[] arg)throws IOException{
//        EventLoopGroup group = new NioEventLoopGroup();
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group)
//                    .channel(NioSocketChannel.class)
//                    .handler(new HelloClientInitializer());
//
//            Channel ch = b.connect(HOST, PORT).sync().channel();
//            int version = 1;
//            String sessionId = UUID.randomUUID().toString();
//            String content = "i'm client message";
//
//            ServiceHeader header = new ServiceHeader(version, content.length(), sessionId);
//            ServiceMessage message = new ServiceMessage(content);
//            message.setServiceHeader(header);
//            ch.writeAndFlush(message);
//            ch.closeFuture().sync();
//        } catch (InterruptedException e){
//
//        }finally {
//            group.shutdownGracefully();
//        }
//
//    }
//}
