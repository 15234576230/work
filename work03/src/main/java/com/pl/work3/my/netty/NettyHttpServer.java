package com.pll.work3.my.netty;

import com.pll.work3.inbound.HttpInboundServer;

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
