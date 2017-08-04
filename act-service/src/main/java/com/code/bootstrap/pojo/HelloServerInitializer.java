package com.code.bootstrap.pojo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * 通道初始化
 * Created by 刘长申 on 2017/8/1.
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        ChannelPipeline pipeline = socketChannel.pipeline();
//        //编码、解码器
//        pipeline.addLast("encoder", new ServerEncoder());
//        pipeline.addLast("decoder", new ServerDecoder());
//        //处理逻辑
//        pipeline.addLast("handler", new HelloServerHandler());
    }
}
