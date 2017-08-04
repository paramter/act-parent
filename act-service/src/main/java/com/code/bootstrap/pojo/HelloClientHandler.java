package com.code.bootstrap.pojo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 客户端事件处理
 * Created by 刘长申 on 2017/8/1.
 */
public class HelloClientHandler extends SimpleChannelInboundHandler<String> {

    protected void messageReceived(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+" say:"+s);
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

    }
}
