package com.example.blog.service;

import com.example.blog.domain.User;
import com.example.blog.domain.UserExample;
import com.example.blog.exception.BusinessException;
import com.example.blog.exception.BusinessExceptionCode;
import com.example.blog.mapper.UserMapper;
import com.example.blog.req.UserLoadingReq;
import com.example.blog.req.UserReq;
import com.example.blog.req.UserSaveReq;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.UserLoadingResp;
import com.example.blog.resp.UserResp;
import com.example.blog.util.CopyUtil;
import com.example.blog.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class UserService {
    //打印日志
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);
    @Resource
    public UserMapper userMapper;
    @Resource
    private SnowFlake snowFlake;

    @Resource
    public RedisTemplate redisTemplate;
    public PageResp<UserResp> list(UserReq req) {
        //固定写法
        UserExample example = new UserExample();
        //固定写法
        UserExample.Criteria criteria = example.createCriteria();
        //条件查询
        if (!ObjectUtils.isEmpty(req.getUsername())) {
            criteria.andUsernameLike("%" + req.getUsername() + "%");
        }
        if (!ObjectUtils.isEmpty(req.getEmail())) {
            criteria.andEmailLike("%" + req.getEmail() + "%");
        }
        if (!ObjectUtils.isEmpty(req.getPhone())) {
            criteria.andPhoneLike("%" + req.getPhone() + "%");
        }
        if (!ObjectUtils.isEmpty(req.getUserSex())) {
            criteria.andUserSexLike("%" + req.getUserSex() + "%");
        }
        if (!ObjectUtils.isEmpty(req.getAvatar())) {
            criteria.andAvatarLike("%" + req.getAvatar() + "%");
        }
        if (!ObjectUtils.isEmpty(req.getFirstname())) {
            criteria.andFirstnameLike("%" + req.getFirstname() + "%");
        }
        //分页(获取从页面传来的数据)
        PageHelper.startPage(req.getPage(), req.getSize());
        //定义分页
        PageResp<UserResp> pageResp = new PageResp<>();
        //List<User> userList = (List<User>) redisTemplate.opsForValue().get("redis:userall:");
        //LOG.info("获取了redis数据{}",userList);
        //if(userList == null){
            //数据库中查
            //类接收返回的数据
            //userList = userMapper.selectByExample(example);
            //写入Redis缓存
            //redisTemplate.opsForValue().set("redis:userall:", userList);
            //LOG.info("redis数据{}",userList);
        //}
        //类接收返回的数据
        List<User> userList = userMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<UserResp> data = CopyUtil.copyList(userList, UserResp.class);
        //定义分页获取总数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }

    //保存数据
    public void save(UserSaveReq userSaveReq) {
        User user = CopyUtil.copy(userSaveReq, User.class);
        //增加数据
        if (ObjectUtils.isEmpty(userSaveReq.getUserid())) {
            user.setUserid(snowFlake.nextId());
            user.setUserRegisterTime(new Date());
            user.setLastLogin(new Date());
            userMapper.insertSelective(user);
        } else {
            //更新数据
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    //删除数据
    public void delete(Long userid) {
        //删除数据
        userMapper.deleteByPrimaryKey(userid);
    }

    //批量删除数据
    public void deletearr(Long[] userid) {
        //删除数据
        userMapper.deleteByIds(userid);
    }
    //查询是否有相同的用户名
    public User selectByLoginName(String LoadingName){
        //固定写法
        UserExample example = new UserExample();
        //固定写法
        UserExample.Criteria criteria = example.createCriteria();
        //查询用户名
        criteria.andUsernameEqualTo(LoadingName);
        //返回查询的实体类
        List<User> userList = userMapper.selectByExample(example);
        //判断是否有数据
        if(CollectionUtils.isEmpty(userList)){
            return null;
        }else{
            return userList.get(0);
        }
    }
    //查询用户信息,通过用户ID
    public UserResp userinfo(Long userid) {
        //固定写法
        UserExample example = new UserExample();
        //固定写法
        UserExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(userid)) {
            criteria.andUseridEqualTo(userid);
        }
        //类接收返回的数据
        User user = userMapper.selectByPrimaryKey(userid);
        //将返回的数据进行封装,某些信息是不需要返回的
        UserResp data = CopyUtil.copy(user,UserResp.class);
        return data;
    }
    public UserLoadingResp loading(UserLoadingReq userLoadingReq) {
        User user = selectByLoginName(userLoadingReq.getUsername());
        if(ObjectUtils.isEmpty(user)){
            //判断用户名是否一样
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        }else{
            if(user.getPassword().equals(userLoadingReq.getPassword())){
                //登录成功
                UserLoadingResp userLoadingResp = CopyUtil.copy(user,UserLoadingResp.class);
                LOG.info("登录成功");
                return userLoadingResp;
            }else{
                //账号或者密码错误
                throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
            }
        }
    }

}
