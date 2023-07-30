package com.example.blog.service;

import com.example.blog.domain.Tag;
import com.example.blog.domain.TagExample;
import com.example.blog.mapper.TagMapper;
import com.example.blog.req.TagReq;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagResp;
import com.example.blog.util.CopyUtil;
import com.example.blog.util.SnowFlake;
import com.example.blog.websocket.WebSocketServer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class WebSocsService {
    //打印日志
    /*private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);*/
    @Resource
    public WebSocketServer webSocketServer;

    @Async
    public void sendInfo(String message){
        webSocketServer.sendInfo(message);
    }
}
