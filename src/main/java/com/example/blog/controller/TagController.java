package com.example.blog.controller;

import com.example.blog.req.BlogFindReq;
import com.example.blog.req.BlogReq;
import com.example.blog.req.TagReq;
import com.example.blog.resp.BlogResp;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagResp;
import com.example.blog.service.BlogService;
import com.example.blog.service.TagService;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Resource
    private TagService tagService;

    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(TagReq tagReq) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<TagResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<TagResp> data = tagService.list(tagReq);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }

    @GetMapping("/bloglist")
    //获取固定博客的标签
    public CommonResp GetBlogTag(Integer blogId) {
        //返回信息里面定义返回的类型
        CommonResp<List<TagResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        List<TagResp> data = tagService.bloglist(blogId);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }

    //单个增加
    @PostMapping("/save")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp save(@Validated @RequestBody TagReq tagReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        tagService.save(tagReq);
        //将信息添加到返回信息里
        if (ObjectUtils.isEmpty(tagReq.getTagId())) {
            resp.setMessage("保存成功");
        } else {
            resp.setMessage("修改成功");
        }
        //将信息添加到返回信息里
        return resp;
    }

    //单个删除
    @GetMapping("/delete/{tagId}")
    //@PathVariable与{blogId}是绑定的
    public CommonResp delete(@PathVariable Integer tagId) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除数据
        tagService.delete(tagId);
        //将信息添加到返回信息里
        resp.setMessage("删除成功");
        return resp;
    }
}
