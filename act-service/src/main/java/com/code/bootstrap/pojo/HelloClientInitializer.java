package com.code.bootstrap.pojo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 客户端初始化通道
 * Created by 刘长申 on 2017/8/1.
 */
public class HelloClientInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        ChannelPipeline pipeline = socketChannel.pipeline();
//        pipeline.addLast("encoder", new ServerEncoder());
//        pipeline.addLast("decoder", new ServerDecoder());
//
//        // 客户端的逻辑
//        pipeline.addLast("handler", new HelloClientHandler());
    }
}
