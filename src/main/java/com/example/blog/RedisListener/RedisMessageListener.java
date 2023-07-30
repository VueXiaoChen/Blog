package com.example.blog.RedisListener;

import com.example.blog.exception.RedisCode;
import com.example.blog.service.RedisService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisMessageListener {
    /**
     * redis消息监听器容器
     *
     * @param connectionFactory
     * @param praiseListenerAdapter
     *            点赞消息订阅处理器
     * @param collectListenerAdapter
     *            收藏消息订阅处理器
     * @param commentListenerAdapter
     *            评论消息订阅处理器
     * @param focusListenerAdapter
     *            关注消息订阅处理器
     * @return
     */


    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter praiseListenerAdapter, MessageListenerAdapter collectListenerAdapter,
                                            MessageListenerAdapter commentListenerAdapter, MessageListenerAdapter focusListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 以下为修改默认的序列化方式，网上大多数消息发布订阅都是String类型,但是实际中数据类型肯定不止String类型
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
                Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);


        //StringRedisSerializer stringRedisSerializer =new StringRedisSerializer();

        // 针对每一个消息处理可以设置不同的序列化方式
        praiseListenerAdapter.setSerializer(jackson2JsonRedisSerializer);
        // 点赞主题并绑定消息订阅处理器
        container.addMessageListener(praiseListenerAdapter, new PatternTopic(RedisCode.TOPIC_PRAISE));
        // 收藏主题并绑定消息订阅处理器
        collectListenerAdapter.setSerializer(jackson2JsonRedisSerializer);
        container.addMessageListener(collectListenerAdapter, new PatternTopic(RedisCode.TOPIC_COLLECT));
        // 评论主题并绑定消息订阅处理器
        commentListenerAdapter.setSerializer(jackson2JsonRedisSerializer);
        container.addMessageListener(commentListenerAdapter, new PatternTopic(RedisCode.TOPIC_COMMENT));
        // 关注主题并绑定消息订阅处理器
        focusListenerAdapter.setSerializer(jackson2JsonRedisSerializer);
        container.addMessageListener(focusListenerAdapter, new PatternTopic(RedisCode.TOPIC_FOCUS));
        return container;
    }


    /**
     * 点赞消息订阅处理器,并指定处理方法
     *
     * @param receiver
     * @return
     */
    @Bean
    MessageListenerAdapter praiseListenerAdapter(RedisService receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "praiseReceive");
        return messageListenerAdapter;
    }

    /**
     * 收藏消息订阅处理器,并指定处理方法
     *
     * @param receiver
     * @return
     */
    @Bean
    MessageListenerAdapter collectListenerAdapter(RedisService receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "collectReceive");
        return messageListenerAdapter;
    }

    /**
     * 评论消息订阅处理器,并指定处理方法
     *
     * @param receiver
     * @return
     */
    @Bean
    MessageListenerAdapter commentListenerAdapter(RedisService receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "commentReceive");
        return messageListenerAdapter;
    }

    /**
     * 关注消息订阅处理器,并指定处理方法
     *
     * @param receiver
     * @return
     */
    @Bean
    MessageListenerAdapter focusListenerAdapter(RedisService receiver) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "focusReceive");
        return messageListenerAdapter;
    }

}
