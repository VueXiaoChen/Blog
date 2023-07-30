package com.example.blog.job;

import com.example.blog.service.WebSocsService;
import com.example.blog.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
@Component
public class Test {
    /*private static final Logger LOG = LoggerFactory.getLogger(Test.class);
    @Resource
    private WebSocsService webSocsService;
    @Scheduled(cron = "0/5 * * * * ?")
    public void cron() throws InterruptedException{
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        String dateString =format.format(new Date());
        webSocsService.sendInfo("我是测试webSocket的","55555555555");
        LOG.info("每隔5秒执行一次:{}",dateString);
    }*/
}
