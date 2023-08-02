package com.example.blog.service;

import com.example.blog.domain.RedisTest;
import com.example.blog.domain.RedisTestExample;
import com.example.blog.mapper.RedisTestMapper;
import com.example.blog.req.RedisTestReq;
import com.example.blog.resp.RedisTestResp;
import com.example.blog.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

}


