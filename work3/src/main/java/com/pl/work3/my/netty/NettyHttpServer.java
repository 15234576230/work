package com.pl.work3.my.netty;

import com.pl.work3.inbound.HttpInboundInitializer;
import com.pl.work3.inbound.HttpInboundServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.ArrayList;
import java.util.List;

public class NettyHttpServer {
    public static void main(String[] args) throws InterruptedException {

        List<String> servers = new ArrayList<>();
        servers.add("http://localhost:8088/");
        HttpInboundServer server = new HttpInboundServer(8888, servers);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
