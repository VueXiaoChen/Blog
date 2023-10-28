package com.example.blog.RedisMessageReceive;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.blog.req.WebMessageReq;
import com.example.blog.resp.BlogResp;
import com.example.blog.service.WebSocsService;
import com.example.blog.util.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.example.blog.util.RedisUtil;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


@Component
public class RedisReceiver{

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(RedisReceiver.class);

    @Resource
    public WebSocsService webSocsService;

    private Session session;
    public Session getSession() {   return session;  }
    public void setSession(Session session) {
        this.session = session;
    }

    //重点:controller里面的值都不能带入到这个方法里来
    public void praiseReceive(String blog){
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        //webSocsService.sendInfo(m.getUserid()+"点赞了《"+m.getBlogTitle()+"》文章","");
        WebMessageReq webMessageReq =new WebMessageReq();
        webMessageReq.setType("2");
        webMessageReq.setComment(m.getUserid()+"关注了《"+m.getBlogTitle()+"》文章");
        webSocsService.sendtoUser(JSON.toJSONString(webMessageReq),"userid"+m.getUserid());
        LOG.info("消费点赞数据:{}", m);
    }
    public void nopraiseReceive(String blog) throws IOException {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        //webSocsService.sendInfo(m.getUserid()+"取消了《"+m.getBlogTitle()+"》文章的点赞","");
        WebMessageReq webMessageReq =new WebMessageReq();
        webMessageReq.setType("2");
        webMessageReq.setComment(m.getUserid()+"取消了《"+m.getBlogTitle()+"》文章的点赞");
        webSocsService.sendtoUser(JSON.toJSONString(webMessageReq),"userid"+m.getUserid());
        LOG.info("消费点赞数据:{}", m);
    }

    public void collectReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        //webSocsService.sendInfo(m.getUserid()+"收藏了《"+m.getBlogTitle()+"》文章","");
        webSocsService.sendtoUser(m.getUserid()+"收藏了《"+m.getBlogTitle()+"》文章","userid"+m.getUserid());
        LOG.info("消费收藏数据:[{}]", m);
    }
    public void nocollectReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        //webSocsService.sendInfo(m.getUserid()+"取消了《"+m.getBlogTitle()+"》文章的收藏","");
        webSocsService.sendtoUser(m.getUserid()+"取消了《"+m.getBlogTitle()+"》文章的收藏","userid"+m.getUserid());
        LOG.info("消费收藏数据:[{}]", m);
    }

    public void commentReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSocsService.sendInfo(m.getUserid()+"评论了《"+m.getBlogTitle()+"》文章","");
        webSocsService.sendtoUser(m.getUserid()+"评论了《"+m.getBlogTitle()+"》文章","userid"+m.getUserid());
        LOG.info("消费评论数据:[{}]", m);
    }
    public void nocommentReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSocsService.sendInfo(m.getUserid()+"取消了《"+m.getBlogTitle()+"》文章的评论","");
        webSocsService.sendtoUser(m.getUserid()+"取消了《"+m.getBlogTitle()+"》文章的评论","userid"+m.getUserid());
        LOG.info("消费评论数据:[{}]", m);
    }

    public void focusReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        //webSocsService.sendInfo(m.getUserid()+"关注了《"+m.getBlogTitle()+"》文章","");

        webSocsService.sendtoUser(m.getUserid()+"关注了《"+m.getBlogTitle()+"》文章","userid"+m.getUserid());
        LOG.info("消费关注数据:[{}]", m);
    }
    public void nofocusReceive(String blog) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(blog);
        //将数组转换成对象
        BlogResp m = JSON.parseObject(JSON.toJSONString(arr.get(1)),BlogResp.class);
        //webSock发送消息
        //webSocsService.sendInfo(m.getUserid()+"取消了《"+m.getBlogTitle()+"》文章的关注","");
        webSocsService.sendtoUser(m.getUserid()+"取消了《"+m.getBlogTitle()+"》文章的关注","userid"+m.getUserid());
        LOG.info("消费关注数据:[{}]", m);
    }

    public void sendall(String message) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(message);
        //将数组转换成对象
        WebMessageReq m = JSON.parseObject(JSON.toJSONString(arr.get(1)),WebMessageReq.class);
        WebMessageReq webMessageReq =new WebMessageReq();
        webMessageReq.setType("2");
        webMessageReq.setComment(m.getComment());
        //webSock发送消息
        webSocsService.sendInfo(JSON.toJSONString(webMessageReq),"");
        LOG.info("消费关注数据:[{}]", m);
    }

    public void send(String message) {
        //将传过来的字符串转换成数组
        JSONArray arr = JSON.parseArray(message);
        //将数组转换成对象
        WebMessageReq m = JSON.parseObject(JSON.toJSONString(arr.get(1)),WebMessageReq.class);
        //webSock发送消息
        webSocsService.sendInfo(m.getUserid()+"123456","");
        LOG.info("消费关注数据:[{}]", m);
    }

//    @Override
//    public void onMessage(Message message, byte[] bytes) {
//        String msg = new String(message.getBody());
//        System.out.println(new String(bytes) + "主题发布：" + msg);
//        if (null != session && session.isOpen()) {
//            try {
//                session.getBasicRemote().sendText(msg);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
