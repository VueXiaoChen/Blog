package com.example.blog.controller;

import com.example.blog.req.TagBlogReq;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagBlogResp;
import com.example.blog.service.TagBlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tagblog")
public class TagBlogController {
    @Resource
    private TagBlogService tagBlogService;

    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(TagBlogReq tagBlogReq) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<TagBlogResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<TagBlogResp> data = tagBlogService.list(tagBlogReq);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
    //单个增加
}
