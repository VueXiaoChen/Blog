package com.example.blog.controller;

import com.example.blog.req.BlogFindReq;
import com.example.blog.req.BlogReq;
import com.example.blog.resp.BlogResp;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.service.BlogService;
import com.example.blog.util.Mylog;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogService blogService;
    @Mylog(value="查询博客")
    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(@Validated BlogFindReq blogFindReq) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<BlogResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<BlogResp> data = blogService.list(blogFindReq);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }

    //单个增加
    @Mylog(value="保存博客")
    @PostMapping("/save")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp save(@Validated @RequestBody BlogReq blogReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        blogService.save(blogReq);
        //将信息添加到返回信息里
        if (ObjectUtils.isEmpty(blogReq.getBlogId())) {
            resp.setMessage("保存成功");
        } else {
            resp.setMessage("修改成功");
        }
        //将信息添加到返回信息里
        return resp;
    }
    @Mylog(value="点赞")
    @PostMapping("/like")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp like(@Validated @RequestBody BlogReq blogReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        blogService.like(blogReq);
        //将信息添加到返回信息里
        resp.setMessage("点赞成功");
        //将信息添加到返回信息里
        return resp;
    }
    @Mylog(value="关注")
    @PostMapping("/focus")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp focus(@Validated @RequestBody BlogReq blogReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        blogService.focus(blogReq);
        //将信息添加到返回信息里
        resp.setMessage("关注成功");
        //将信息添加到返回信息里
        return resp;
    }
    @Mylog(value="收藏")
    @PostMapping("/collect")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp collect(@Validated @RequestBody BlogReq blogReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        blogService.collect(blogReq);
        //将信息添加到返回信息里
        resp.setMessage("收藏成功");
        //将信息添加到返回信息里
        return resp;
    }
    @Mylog(value="删除博客")
    //单个删除
    @GetMapping("/delete/{blogId}")
    //@PathVariable与{blogId}是绑定的
    public CommonResp delete(@PathVariable long blogId) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除数据
        blogService.delete(blogId);
        //将信息添加到返回信息里
        resp.setMessage("删除成功");
        return resp;
    }
}
