package com.example.blog.controller;

import com.example.blog.exception.RedisCode;
import com.example.blog.req.BlogReq;
import com.example.blog.req.TagBlogReq;
import com.example.blog.req.WebMessageReq;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagBlogResp;
import com.example.blog.service.TagBlogService;
import com.example.blog.util.Mylog;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/webmessage")
public class MessageController {

    @Resource
    public RedisTemplate redisTemplate;
    @PostMapping("/sendall")
    //@Valid  开启参数检验
    public void sendall(@RequestBody WebMessageReq webMessageReq) {
        redisTemplate.convertAndSend(RedisCode.TOPIC_SENDALL,webMessageReq);
    }
    @PostMapping("/send")
    public void send(@RequestBody WebMessageReq webMessageReq) {
        redisTemplate.convertAndSend(RedisCode.TOPIC_SEND,webMessageReq);
    }
    //单个增加
}
