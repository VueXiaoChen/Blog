package com.example.blog.controller;

import com.example.blog.domain.User;
import com.example.blog.req.UserReq;
import com.example.blog.req.UserSaveReq;
import com.example.blog.resp.CommonResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.PasswordReq;
import com.example.blog.resp.UserResp;
import com.example.blog.service.UserService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import cn.hutool.core.codec.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;



    /*@GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }*/

    @GetMapping("/list")
    //@Valid  开启参数检验
    public CommonResp list(@Valid UserReq req) {
        //返回信息里面定义返回的类型
        CommonResp<PageResp<UserResp>> resp = new CommonResp<>();
        //接收数据库返回的数据
        PageResp<UserResp> data = userService.list(req);
        //将信息添加到返回信息里
        resp.setMessage("获取成功");
        //将信息添加到返回信息里
        resp.setData(data);
        return resp;
    }

    @PostMapping("/save")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp save(@RequestBody UserSaveReq userSaveReq) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //保存数据
        userService.save(userSaveReq);
        //将信息添加到返回信息里
        if (ObjectUtils.isEmpty(userSaveReq.getUserid())) {
            resp.setMessage("保存成功");
        } else {
            resp.setMessage("修改成功");
        }

        return resp;
    }


    @GetMapping("/delete/{userid}")
    //@PathVariable与{userid}是绑定的
    public CommonResp deletes(@PathVariable Long userid) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除数据
        userService.delete(userid);
        //将信息添加到返回信息里
        resp.setMessage("删除成功");
        return resp;
    }

    @GetMapping("/deleteByIds/{userid}")
    public CommonResp deletearrs(@Param("array") @PathVariable Long[] userid) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除数据
        userService.deletearr(userid);
        //将信息添加到返回信息里
        resp.setMessage("删除成功");
        return resp;
    }

    @PostMapping("/getpassword")
    public CommonResp getpassword(@RequestBody PasswordReq req) throws Exception {
        CommonResp resp = new CommonResp<>();

        //String[] split = req.getKey().split("\\\\");
        String[] split = req.getKey().split("\n");
        //String newKey = split[1] + split[2] + split[3] + split[4];
        //System.out.println(split[1]);
        //String[] splits = split[2].split(("/"));
        String newKey = split[1] + split[2] + split[3] + split[4];
        System.out.println(split[1]);
        System.out.println(split[2]);
        System.out.println(split[3]);
        System.out.println(split[4]);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decode(newKey));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.PUBLIC_KEY, publicKey);
        System.out.println(req.getHash());
        System.out.println(req.getPassword());
        byte[] bytes = cipher.doFinal((req.getHash() + req.getPassword()).getBytes());
        String encode = Base64.encode(bytes);
        System.out.println(encode);
        resp.setData(encode);
        return resp;
    }
}
