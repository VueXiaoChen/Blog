package com.example.blog.controller;

import com.example.blog.req.BlogReq;
import com.example.blog.req.TagBlogReq;
import com.example.blog.req.WebMessageReq;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagBlogResp;
import com.example.blog.service.TagBlogService;
import com.example.blog.util.Mylog;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/webmessage")
public class MessageController {
    @PostMapping("/sendall")
    //@Valid  开启参数检验
    public void sendall(@RequestBody WebMessageReq webMessageReq) {

    }
    @PostMapping("/send")
    public void send(@RequestBody WebMessageReq webMessageReq) {

    }
    //单个增加
}
