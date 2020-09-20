package com.lj.socketdemo.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableScheduling
public class TimeTaskServer {

    @Autowired
    private WebSocketServer webSocketServer;

//    @Scheduled(fixedDelay = 10000)
//    private void taskRun(){
//        webSocketServer.sendInfo("10","后台返回数据啦！！");
//    }
}
