package com.example.blog.controller;

import com.example.blog.resp.CommonResp;
import com.example.blog.resp.RedisTestResp;
import com.example.blog.service.RedisTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Resource
    private RedisTestService redisTestService;

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
}