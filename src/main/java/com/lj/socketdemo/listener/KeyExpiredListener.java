package com.lj.socketdemo.listener;

import com.lj.socketdemo.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.nio.charset.StandardCharsets;

public class KeyExpiredListener extends KeyExpirationEventMessageListener {


    private static final Logger LOGGER = LoggerFactory.getLogger(KeyExpiredListener.class);

    @Autowired
    private WebSocketServer webSocketServer;

    public KeyExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel(), StandardCharsets.UTF_8);

        //过期的key
        String key = new String(message.getBody(),StandardCharsets.UTF_8);
        //LOGGER.info("redis key 过期：pattern={},channel={},key={}",new String(pattern),channel,key);
        webSocketServer.sendInfo("10","Key已过期，请提醒用户续期！！");
    }
}
