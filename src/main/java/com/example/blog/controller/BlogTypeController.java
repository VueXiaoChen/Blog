package com.example.blog.controller;

import com.example.blog.req.BlogTypeReq;
import com.example.blog.resp.BlogTypeResp;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.service.BlogTypeService;
import com.example.blog.util.Mylog;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/blogtype")
public class BlogTypeController {
    @Resource
    private BlogTypeService blogTypeService;
    @Mylog(value="查询博客类别")
    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(@Valid BlogTypeReq blogTypeReq) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<BlogTypeResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<BlogTypeResp> data = blogTypeService.list(blogTypeReq);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }
    @Mylog(value="id查询博客类别")
    //单个id查询
    @GetMapping("/find/{typeid}")
    //@PathVariable与{userid}是绑定的
    public CommonResp find(@PathVariable Integer typeid) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除数据
        List<BlogTypeResp> data = blogTypeService.FingByTypeId(typeid);
        //将信息添加到返回信息里
        resp.setData(data);
        resp.setMessage("查询成功");
        return resp;
    }
    @Mylog(value="删除博客类别")
    //单个删除
    @GetMapping("/delete/{typeid}")
    //@PathVariable与{typeid}是绑定的
    public CommonResp deletes(@PathVariable Integer typeid) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除数据
        blogTypeService.delete(typeid);
        //将信息添加到返回信息里
        resp.setMessage("删除成功");
        return resp;
    }
    @Mylog(value="保存博客类别")
    //单个增加
    @PostMapping("/save")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp save(@RequestBody BlogTypeReq blogTypeReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        System.out.println(ObjectUtils.isEmpty(blogTypeReq.getTypeName()));
        if (!ObjectUtils.isEmpty(blogTypeReq.getTypeName())) {
            List<BlogTypeResp> blogTypeResps = blogTypeService.FingByTypeName(blogTypeReq.getTypeName());
            if (blogTypeResps.size() >= 1) {
                resp.setMessage("博客类别已经存在");
                return resp;
            } else {
                blogTypeService.save(blogTypeReq);
                if (ObjectUtils.isEmpty(blogTypeReq.getTypeId())) {
                    resp.setMessage("保存成功");
                } else {
                    resp.setMessage("修改成功");
                }
            }
        } else {
            resp.setMessage("博客类名不能为空!");
        }

        //将信息添加到返回信息里
        return resp;
    }
}
