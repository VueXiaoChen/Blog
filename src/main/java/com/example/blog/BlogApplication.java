package com.example.blog;

import com.example.blog.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.xml.stream.events.EndElement;
import java.util.EventListener;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableCaching
public class BlogApplication {
    private static final Logger LOG = LoggerFactory.getLogger(WebSocketServer.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BlogApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功");
        LOG.info("地址:\thttp://127.0.0.1:{}",env.getProperty("server.port"));
    }

}
