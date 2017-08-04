package com.code.bootstrap.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http服务
 * Created by 刘长申 on 2017/8/3.
 */
public class BootStrapServer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
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
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //使用httpResponseEncoder编码
                            ch.pipeline().addLast(new HttpResponseEncoder());
                            //使用httpRequestDecoder解码
                            ch.pipeline().addLast(new HttpRequestDecoder());
                            //添加业务处理类
                            ch.pipeline().addLast(new HttpServerHandler());
                        }
                    });
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
