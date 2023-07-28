package com.example.blog.service;

import com.example.blog.domain.BlogType;
import com.example.blog.domain.BlogTypeExample;
import com.example.blog.domain.User;
import com.example.blog.domain.UserExample;
import com.example.blog.mapper.BlogMapper;
import com.example.blog.mapper.BlogTypeMapper;
import com.example.blog.mapper.UserMapper;
import com.example.blog.req.BlogTypeReq;
import com.example.blog.req.UserReq;
import com.example.blog.req.UserSaveReq;
import com.example.blog.resp.BlogTypeResp;
import com.example.blog.resp.CommonResp;
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
public class BlogTypeService {
    //打印日志
    /*private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);*/
    @Resource
    public BlogTypeMapper blogTypeMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<BlogTypeResp> list(BlogTypeReq blogTypeReq) {
        //固定写法
        BlogTypeExample example = new BlogTypeExample();
        //固定写法
        BlogTypeExample.Criteria criteria = example.createCriteria();
        //条件查询
        if (!ObjectUtils.isEmpty(blogTypeReq.getTypeName())) {
            criteria.andTypeNameLike("%" + blogTypeReq.getTypeName() + "%");
        }
        //分页(获取从页面传来的数据)
        PageHelper.startPage(blogTypeReq.getPage(), blogTypeReq.getSize());
        //类接收返回的数据
        List<BlogType> blogTypeList = blogTypeMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<BlogTypeResp> data = CopyUtil.copyList(blogTypeList, BlogTypeResp.class);
        //定义分页获取总数
        PageInfo<BlogType> pageInfo = new PageInfo<>(blogTypeList);
        //定义分页
        PageResp<BlogTypeResp> pageResp = new PageResp<>();
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }

    public List<BlogTypeResp> FingByTypeId(Integer typeid) {
        //固定写法
        BlogTypeExample example = new BlogTypeExample();
        //固定写法
        BlogTypeExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(typeid)) {
            criteria.andTypeIdEqualTo(typeid);
        }
        //类接收返回的数据
        List<BlogType> blogTypeList = blogTypeMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<BlogTypeResp> data = CopyUtil.copyList(blogTypeList, BlogTypeResp.class);
        return data;
    }

    public List<BlogTypeResp> FingByTypeName(String typeName) {
        //固定写法
        BlogTypeExample example = new BlogTypeExample();
        //固定写法
        BlogTypeExample.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(typeName)) {
            criteria.andTypeNameEqualTo(typeName);
        }
        //类接收返回的数据
        List<BlogType> blogTypeList = blogTypeMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<BlogTypeResp> data = CopyUtil.copyList(blogTypeList, BlogTypeResp.class);
        return data;
    }

    //删除数据
    public void delete(Integer typeid) {
        //删除数据
        blogTypeMapper.deleteByPrimaryKey(typeid);
    }

    //保存数据
    public void save(BlogTypeReq blogTypeReq) {
        BlogType blogType = CopyUtil.copy(blogTypeReq, BlogType.class);
        //增加数据
        if (ObjectUtils.isEmpty(blogTypeReq.getTypeId())) {
            blogTypeMapper.insertSelective(blogType);
        } else {
            //更新数据
            blogTypeMapper.updateByPrimaryKeySelective(blogType);
        }
    }

}
