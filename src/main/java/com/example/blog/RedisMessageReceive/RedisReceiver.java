package com.example.blog.RedisMessageReceive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.blog.redis.MessageCollect;
import com.example.blog.redis.MessageComment;
import com.example.blog.redis.MessageFocus;
import com.example.blog.redis.MessagePraise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class RedisReceiver {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(RedisReceiver.class);
    public void praiseReceive(String messagePraise) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(messagePraise);
        //将数组转换成对象
        MessagePraise m = JSON.parseObject(JSON.toJSONString(arr.get(1)),MessagePraise.class);
        LOG.info("消费点赞数据:{}", m);
    }

    public void collectReceive(String messageCollect) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(messageCollect);
        //将数组转换成对象
        MessageCollect m = JSON.parseObject(JSON.toJSONString(arr.get(1)),MessageCollect.class);
        LOG.info("消费收藏数据:[{}]", m);
    }

    public void commentReceive(String messageComment) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(messageComment);
        //将数组转换成对象
        MessageComment m = JSON.parseObject(JSON.toJSONString(arr.get(1)),MessageComment.class);
        LOG.info("消费评论数据:[{}]", m);
    }

    public void focusReceive(String messageFocus) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(messageFocus);
        //将数组转换成对象
        MessageFocus m = JSON.parseObject(JSON.toJSONString(arr.get(1)),MessageFocus.class);
        LOG.info("消费关注数据:[{}]", m);
    }

}
