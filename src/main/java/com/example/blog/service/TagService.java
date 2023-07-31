package com.example.blog.service;

import com.example.blog.domain.*;
import com.example.blog.exception.RedisCode;
import com.example.blog.mapper.BlogMapper;
import com.example.blog.mapper.TagMapper;
import com.example.blog.redis.MessageCollect;
import com.example.blog.req.BlogFindReq;
import com.example.blog.req.BlogReq;
import com.example.blog.req.TagReq;
import com.example.blog.resp.BlogResp;
import com.example.blog.resp.BlogTypeResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagResp;
import com.example.blog.util.CopyUtil;
import com.example.blog.util.SnowFlake;
import com.example.blog.websocket.WebSocketServer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class TagService {
    //打印日志
    /*private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);*/
    @Resource
    public TagMapper tagMapper;

    @Resource
    public WebSocsService webSocsService;
    @Resource
    private SnowFlake snowFlake;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public PageResp<TagResp> list(TagReq tagReq) {
        //固定写法
        TagExample example = new TagExample();
        //固定写法
        TagExample.Criteria criteria = example.createCriteria();
        //条件查询
        //根据ID
        if (!ObjectUtils.isEmpty(tagReq.getTagId())) {
            criteria.andTagIdEqualTo(tagReq.getTagId());
        }
        //
        if (!ObjectUtils.isEmpty(tagReq.getTagName())) {
            criteria.andTagNameLike("%" + tagReq.getTagName() + "%");
        }
        //分页(获取从页面传来的数据)
        PageHelper.startPage(tagReq.getPage(), tagReq.getSize());
        //类接收返回的数据
        List<Tag> tagList = tagMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<TagResp> data = CopyUtil.copyList(tagList, TagResp.class);
        //定义分页获取总数
        PageInfo<Tag> pageInfo = new PageInfo<>(tagList);
        //定义分页
        PageResp<TagResp> pageResp = new PageResp<>();
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        //获取日志流水号ID
        String logId = MDC.get("LOG_ID");
        //webSock发送消息
        webSocsService.sendInfo("我是测试webSocket的",logId);
        MessageCollect messageCollect = new MessageCollect();
        messageCollect.setId("1");
        messageCollect.setTitle("22222222222");
        messageCollect.setUserId("2");
        messageCollect.setToUserId("3");
        messageCollect.setUserName("xiaochen");
        redisTemplate.convertAndSend(RedisCode.TOPIC_PRAISE,messageCollect);
        return pageResp;
    }

    //检查标签是否有重复的
    public List<TagResp> FingByTagName(String tagName) {
        //固定写法
        TagExample example = new TagExample();
        //固定写法
        TagExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(tagName)) {
            criteria.andTagNameEqualTo(tagName);
        }
        //类接收返回的数据
        List<Tag> tagList = tagMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<TagResp> data = CopyUtil.copyList(tagList, TagResp.class);
        return data;
    }

    //保存数据
    public void save(TagReq tagReq) {
        Tag tag = CopyUtil.copy(tagReq, Tag.class);
        //增加数据
        if (ObjectUtils.isEmpty(tagReq.getTagId())) {
            tagMapper.insertSelective(tag);
        } else {
            //更新数据
            tagMapper.updateByPrimaryKeySelective(tag);
        }
    }

    //删除数据
    public void delete(Integer tagId) {
        //删除数据
        tagMapper.deleteByPrimaryKey(tagId);
    }

    //获取博客的标签
    public List<TagResp> bloglist(Integer blogId) {
        List<Tag> tagList = tagMapper.selectByBlogId(blogId);
        List<TagResp> data = CopyUtil.copyList(tagList, TagResp.class);
        return data;
    }
}
