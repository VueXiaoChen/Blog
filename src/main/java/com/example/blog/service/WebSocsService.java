package com.example.blog.service;

import com.example.blog.websocket.WebSocketServer;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class WebSocsService {
    //打印日志
    /*private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);*/
    @Resource
    public WebSocketServer webSocketServer;

    @Async
    public void sendInfo(String message,String logId){
        MDC.put("LOG_ID",logId);
        webSocketServer.sendInfo(message);
    }
}
