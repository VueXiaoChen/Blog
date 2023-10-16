package com.example.blog.controller;

import com.example.blog.req.BlogReq;
import com.example.blog.req.TagReq;
import com.example.blog.req.VideoAddressReq;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagResp;
import com.example.blog.resp.VideoAddressResp;
import com.example.blog.service.TagService;
import com.example.blog.service.VideoAddressService;
import com.example.blog.util.Mylog;
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
    @Mylog(value="查询视频地址")
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
    //单个增加
    @Mylog(value="增加视频地址")
    @PostMapping("/save")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp save(@Validated @RequestBody VideoAddressReq videoAddressReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        videoAddressService.save(videoAddressReq);
        //将信息添加到返回信息里
        if (ObjectUtils.isEmpty(videoAddressReq.getVideoid())) {
            resp.setMessage("保存成功");
        } else {
            resp.setMessage("修改成功");
        }
        //将信息添加到返回信息里
        return resp;
    }
    //单个删除
    @Mylog(value="删除视频地址")
    @GetMapping("/delete/{videoid}")
    //@PathVariable与{videoid}是绑定的
    public CommonResp delete(@PathVariable long videoid) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除数据
        videoAddressService.delete(videoid);
        //将信息添加到返回信息里
        resp.setMessage("删除成功");
        return resp;
    }
}
