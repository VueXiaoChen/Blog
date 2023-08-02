package com.example.blog.service;

import com.example.blog.domain.RedisTest;
import com.example.blog.domain.RedisTestExample;
import com.example.blog.domain.Tag;
import com.example.blog.mapper.RedisTestMapper;
import com.example.blog.req.RedisTestReq;
import com.example.blog.req.TagReq;
import com.example.blog.resp.RedisTestResp;
import com.example.blog.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RedisTestService {
    //打印日志
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(RedisTestService.class);
    @Resource
    public RedisTestMapper redisTestMapper;

    public List<RedisTestResp> FingByRedisId(Integer redisid) {
        //固定写法
        RedisTestExample example = new RedisTestExample();
        //固定写法
        RedisTestExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(redisid)) {
            criteria.andRedisidEqualTo(redisid);
        }
        //类接收返回的数据
        List<RedisTest> redisTests = redisTestMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<RedisTestResp> data = CopyUtil.copyList(redisTests, RedisTestResp.class);
        return data;
    }

    //保存数据
    public void save(RedisTestReq redisTestReq) {
        RedisTest redisTest = CopyUtil.copy(redisTestReq, RedisTest.class);
        //增加数据
        if (ObjectUtils.isEmpty(redisTestReq.getRedisid())) {
            redisTestMapper.insertSelective(redisTest);
        }
    }
    //更新数据
    public void update(RedisTestReq redisTestReq) {
        RedisTest redisTest = CopyUtil.copy(redisTestReq, RedisTest.class);
        redisTestMapper.updateByPrimaryKeySelective(redisTest);
    }

    //删除数据
    public void delete(Integer redisid) {
        //删除数据
        redisTestMapper.deleteByPrimaryKey(redisid);
    }

}


