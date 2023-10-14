package com.example.blog.controller;

import com.example.blog.req.TagReq;
import com.example.blog.req.VideoAddressReq;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagResp;
import com.example.blog.resp.VideoAddressResp;
import com.example.blog.service.TagService;
import com.example.blog.service.VideoAddressService;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/videoAddress")
public class VideoAddressController {
    @Resource
    private VideoAddressService videoAddressService;

    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(VideoAddressReq videoAddressReq) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<VideoAddressResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<VideoAddressResp> data = videoAddressService.list(videoAddressReq);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
}
