package com.example.blog.controller;

import com.example.blog.req.RedisTestReq;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.RedisTestResp;
import com.example.blog.service.RedisTestService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Resource
    private RedisTestService redisTestService;

    @Cacheable(value = "RedisTestCache",key = "#redisid",unless = "#result == null",condition = "#redisid!=null")
    @GetMapping("/find/{redisid}")
    //@Valid  开启参数检验
    public CommonResp find(Integer redisid) {
        //返回信息里面定义返回的类型
        CommonResp<List<RedisTestResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        List<RedisTestResp> data = redisTestService.FingByRedisId(redisid);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
    //@CachePut(value = "RedisTestCache",key = "#redisTestReq.getRedisid")
    @PostMapping("/save")
    //@Valid  开启参数检验
    public CommonResp save(@RequestBody RedisTestReq redisTestReq) {
        //返回信息里面定义返回的类型
        CommonResp<RedisTestResp> resp = new CommonResp<>();
        //接收数据库返回的数据
        redisTestService.save(redisTestReq);
        //将信息添加到返回信息里
        resp.setMessage("增加成功");
        return resp;
    }

    //@CachePut(value = "RedisTestCache",key = "#redisTestReq.getRedisid")
    @PostMapping("/update")
    //@Valid  开启参数检验
    public CommonResp update(@RequestBody RedisTestReq redisTestReq) {
        //返回信息里面定义返回的类型
        CommonResp<RedisTestResp> resp = new CommonResp<>();
        //接收数据库返回的数据
        redisTestService.update(redisTestReq);
        //将信息添加到返回信息里
        resp.setMessage("更新成功");
        return resp;
    }

    @CacheEvict(value = "RedisTestCache",key="#redisid" ,condition = "#redisid!=null")
    @GetMapping("/delete/{redisid}")
    public CommonResp delete(Integer redisid) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //接收数据库返回的数据
        redisTestService.delete(redisid);
        //将信息添加到返回信息里
        resp.setMessage("删除成功");
        return resp;
    }
}