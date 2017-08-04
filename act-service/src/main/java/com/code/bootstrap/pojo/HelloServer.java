package com.code.bootstrap.pojo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

/**
 * serverBootstrap
 * Created by 刘长申 on 2017/8/1.
 */
public class HelloServer {
    private static final int PORT = 7879;
    public static void main(String[] arg){
        //创建线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap s = new ServerBootstrap();
            s.group(bossGroup,workerGroup)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HelloServerInitializer());
            //绑定端口
            ChannelFuture f = s.bind(PORT).sync();
            //异步等待关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e){
            System.out.println("异常");
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
