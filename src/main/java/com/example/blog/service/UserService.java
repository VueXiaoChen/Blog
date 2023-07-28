package com.example.blog.service;

import com.example.blog.domain.User;
import com.example.blog.domain.UserExample;
import com.example.blog.mapper.UserMapper;
import com.example.blog.req.UserReq;
import com.example.blog.req.UserSaveReq;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.UserResp;
import com.example.blog.util.CopyUtil;
import com.example.blog.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class UserService {
    //打印日志
    /*private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);*/
    @Resource
    public UserMapper userMapper;
    @Resource
    private SnowFlake snowFlake;

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
        //类接收返回的数据
        List<User> userList = userMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<UserResp> data = CopyUtil.copyList(userList, UserResp.class);
        //定义分页获取总数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        //定义分页
        PageResp<UserResp> pageResp = new PageResp<>();
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
}
