package com.example.blog.controller;

import cn.hutool.core.codec.Base64;
import com.example.blog.req.UserLoadingReq;
import com.example.blog.req.UserReq;
import com.example.blog.req.UserSaveReq;
import com.example.blog.resp.*;
import com.example.blog.service.UserService;
import com.example.blog.util.SnowFlake;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.validation.Valid;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowFlake snowFlake;

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

    @PostMapping("/loading")
    //@RequestBody  定义传过来的参数是实体类
    public CommonResp loading(@RequestBody UserLoadingReq userLoadingReq) {
        //返回信息里面定义返回的类型
        CommonResp<UserLoadingResp> resp = new CommonResp<>();
        //保存数据
        UserLoadingResp userLoadingResp = userService.loading(userLoadingReq);
        //雪花算法生成token
        Long token = snowFlake.nextId();
        LOG.info("生成单点登录的token:{},并放入redis中",token);
        //token设置
        userLoadingResp.setToken(token.toString());

        redisTemplate.opsForValue().set(token.toString(),userLoadingResp,3600*24*30, TimeUnit.SECONDS);
        //储存信息
        resp.setMessage("登录成功");
        resp.setData(userLoadingResp);
        return resp;
    }


    @GetMapping("/logout/{token}")
    public CommonResp deletearrs(@PathVariable String token) {
        //返回信息里面定义返回的类型
        CommonResp resp = new CommonResp<>();
        //删除token
        redisTemplate.delete(token);
        LOG.info("删除token:{}",token);
        //将信息添加到返回信息里
        resp.setMessage("退出成功");
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
