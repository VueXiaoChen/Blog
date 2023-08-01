package com.example.blog.service;

import com.example.blog.domain.TagBlog;
import com.example.blog.domain.TagBlogExample;
import com.example.blog.mapper.TagBlogMapper;
import com.example.blog.req.TagBlogReq;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagBlogResp;
import com.example.blog.util.CopyUtil;
import com.example.blog.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TagBlogService {
    //打印日志
    /*private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);*/
    @Resource
    public TagBlogMapper tagBlogMapper;

    @Resource
    private SnowFlake snowFlake;


    public PageResp<TagBlogResp> list(TagBlogReq tagBlogReq) {
        //固定写法
        TagBlogExample example = new TagBlogExample();
        //固定写法
        TagBlogExample.Criteria criteria = example.createCriteria();
        //条件查询
        //根据ID
        if (!ObjectUtils.isEmpty(tagBlogReq.getBlogId())) {
            criteria.andBlogIdEqualTo(tagBlogReq.getBlogId());
        }
        if (!ObjectUtils.isEmpty(tagBlogReq.getTagId())) {
            criteria.andTagIdEqualTo(tagBlogReq.getTagId());
        }
        //分页(获取从页面传来的数据)
        PageHelper.startPage(tagBlogReq.getPage(), tagBlogReq.getSize());
        //类接收返回的数据
        List<TagBlog> tagBlogList = tagBlogMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<TagBlogResp> data = CopyUtil.copyList(tagBlogList, TagBlogResp.class);
        //定义分页获取总数
        PageInfo<TagBlog> pageInfo = new PageInfo<>(tagBlogList);
        //定义分页
        PageResp<TagBlogResp> pageResp = new PageResp<>();
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }
}
