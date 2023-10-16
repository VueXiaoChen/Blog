package com.example.blog.controller;

import com.example.blog.req.CommentReq;
import com.example.blog.resp.CommentResp;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.service.CommentService;
import com.example.blog.util.Mylog;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Mylog(value="查询博客内容")
    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(@Validated CommentReq commentReq) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<CommentResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<CommentResp> data = commentService.list(commentReq);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
    @Mylog(value="保存博客内容")
    //单个增加
    @PostMapping("/save")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp save(@Validated @RequestBody CommentReq commentReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        commentService.save(commentReq);
        //将信息添加到返回信息里
        if (ObjectUtils.isEmpty(commentReq.getCommentId())) {
            resp.setMessage("保存成功");
        } else {
            resp.setMessage("修改成功");
        }
        //将信息添加到返回信息里
        return resp;
    }
    @Mylog(value="删除博客内容")
    @GetMapping("/delete/{commentId}")
    //删除数据
    public CommonResp delete(@PathVariable Long commentId) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除数据
        commentService.delete(commentId);
        //将信息添加到返回信息里
        resp.setMessage("删除成功");
        return resp;
    }
}
