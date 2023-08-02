//package com.example.blog.RedisListener;
//
//import com.example.blog.RedisMessageReceive.RedisReceiver;
//import com.example.blog.exception.RedisCode;
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class RedisMessageListener {
//    /**
//     * redis消息监听器容器
//     *
//     * @param connectionFactory
//     * @param praiseListenerAdapter
//     *            点赞消息订阅处理器
//     * @param collectListenerAdapter
//     *            收藏消息订阅处理器
//     * @param commentListenerAdapter
//     *            评论消息订阅处理器
//     * @param focusListenerAdapter
//     *            关注消息订阅处理器
//     * @return
//     */
//
//
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//                                            MessageListenerAdapter praiseListenerAdapter, MessageListenerAdapter collectListenerAdapter,
//                                            MessageListenerAdapter commentListenerAdapter, MessageListenerAdapter focusListenerAdapter) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//
//        // 点赞主题并绑定消息订阅处理器
//        container.addMessageListener(praiseListenerAdapter, new PatternTopic(RedisCode.TOPIC_PRAISE));
//        // 收藏主题并绑定消息订阅处理器
//        container.addMessageListener(collectListenerAdapter, new PatternTopic(RedisCode.TOPIC_COLLECT));
//        // 评论主题并绑定消息订阅处理器
//        container.addMessageListener(commentListenerAdapter, new PatternTopic(RedisCode.TOPIC_COMMENT));
//        // 关注主题并绑定消息订阅处理器
//        container.addMessageListener(focusListenerAdapter, new PatternTopic(RedisCode.TOPIC_FOCUS));
//        return container;
//    }
//    /**redis 读取内容的template */
//    @Bean
//    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
//        return new StringRedisTemplate(connectionFactory);
//    }
//    @Bean
//    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(connectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//
//    }
//    /**
//     * 点赞消息订阅处理器,并指定处理方法
//     *
//     * @param receiver
//     * @return
//     */
//    @Bean
//    MessageListenerAdapter praiseListenerAdapter(RedisReceiver receiver) {
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "praiseReceive");
//        return messageListenerAdapter;
//    }
//
//    /**
//     * 收藏消息订阅处理器,并指定处理方法
//     *
//     * @param receiver
//     * @return
//     */
//    @Bean
//    MessageListenerAdapter collectListenerAdapter(RedisReceiver receiver) {
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "collectReceive");
//        return messageListenerAdapter;
//    }
//
//    /**
//     * 评论消息订阅处理器,并指定处理方法
//     *
//     * @param receiver
//     * @return
//     */
//    @Bean
//    MessageListenerAdapter commentListenerAdapter(RedisReceiver receiver) {
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "commentReceive");
//        return messageListenerAdapter;
//    }
//
//    /**
//     * 关注消息订阅处理器,并指定处理方法
//     *
//     * @param receiver
//     * @return
//     */
//    @Bean
//    MessageListenerAdapter focusListenerAdapter(RedisReceiver receiver) {
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "focusReceive");
//        return messageListenerAdapter;
//    }
//
//}
