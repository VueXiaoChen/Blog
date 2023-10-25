package com.example.blog.RedisMessageReceive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.blog.resp.BlogResp;
import com.example.blog.service.WebSocsService;
import com.example.blog.util.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.example.blog.util.RedisUtil;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


@Component
public class RedisReceiver {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(RedisReceiver.class);

    @Resource
    public WebSocsService webSocsService;


    //重点:controller里面的值都不能带入到这个方法里来
    public void praiseReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        webSocsService.sendInfo("你点赞了《"+m.getBlogTitle()+"》文章","");
        LOG.info("消费点赞数据:{}", m);
    }

    public void collectReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        webSocsService.sendInfo("你收藏了《"+m.getBlogTitle()+"》文章","");
        LOG.info("消费收藏数据:[{}]", m);
    }

    public void commentReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        webSocsService.sendInfo("你评论了《"+m.getBlogTitle()+"》文章","");
        LOG.info("消费评论数据:[{}]", m);
    }

    public void focusReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        webSocsService.sendInfo("你关注了《"+m.getBlogTitle()+"》文章","");
        LOG.info("消费关注数据:[{}]", m);
    }

}
