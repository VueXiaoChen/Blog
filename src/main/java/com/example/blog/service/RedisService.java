package com.example.blog.service;

import com.example.blog.redis.MessageCollect;
import com.example.blog.redis.MessageComment;
import com.example.blog.redis.MessageFocus;
import com.example.blog.redis.MessagePraise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class RedisService {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(RedisService.class);

    public void praiseReceive(MessagePraise messagePraise) {
        LOG.info("消费点赞数据:[{}]", messagePraise);
    }

    public void collectReceive(MessageCollect messageCollect) {
        LOG.info("消费收藏数据:[{}]", messageCollect);
    }

    public void commentReceive(MessageComment messageComment) {
        LOG.info("消费评论数据:[{}]", messageComment);
    }

    public void focusReceive(MessageFocus messageFocus) {
        LOG.info("消费关注数据:[{}]", messageFocus);
    }

}
