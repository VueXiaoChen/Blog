package com.example.blog.service;

import com.example.blog.domain.*;
import com.example.blog.mapper.BlogMapper;
import com.example.blog.mapper.BlogTypeMapper;
import com.example.blog.mapper.TagBlogMapper;
import com.example.blog.mapper.TagMapper;
import com.example.blog.req.BlogFindReq;
import com.example.blog.req.BlogReq;
import com.example.blog.req.BlogTypeReq;
import com.example.blog.resp.BlogResp;
import com.example.blog.resp.BlogTypeResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagResp;
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
public class BlogService {
    //打印日志
    /*private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);*/
    @Resource
    public BlogMapper blogMapper;
    @Resource
    public TagBlogMapper tagBlogMapper;
    @Resource
    public TagMapper tagMapper;

    @Resource
    private SnowFlake snowFlake;


    public PageResp<BlogResp> list(BlogFindReq blogFindReq) {
        //固定写法
        BlogExample example = new BlogExample();
        //固定写法
        BlogExample.Criteria criteria = example.createCriteria();
        //条件查询
        //大于或等于创建时间
        if (!ObjectUtils.isEmpty(blogFindReq.getCreateTime())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(blogFindReq.getCreateTime());
        }
        //根据标题
        if (!ObjectUtils.isEmpty(blogFindReq.getBlogTitle())) {
            criteria.andBlogTitleLike("%" + blogFindReq.getBlogTitle() + "%");
        }
        //根据用户ID
        if (!ObjectUtils.isEmpty(blogFindReq.getUserid())) {
            criteria.andUseridEqualTo(blogFindReq.getUserid());
        }
        //未审核的文章
        if (!ObjectUtils.isEmpty(blogFindReq.getBlogStatus())) {
            criteria.andBlogStatusEqualTo(blogFindReq.getBlogStatus());
        }
        //分页(获取从页面传来的数据)
        PageHelper.startPage(blogFindReq.getPage(), blogFindReq.getSize());
        //类接收返回的数据
        List<Blog> blogList = blogMapper.selectByExampleWithBLOBs(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<BlogResp> data = CopyUtil.copyList(blogList, BlogResp.class);
        //将标签加入的数据里面
        for (int i = 0; i < data.size(); i++) {
            //long转化成Integer
            Integer blogId = Integer.valueOf(Long.toString(data.get(i).getBlogId()));
            List<Tag> tagList = tagMapper.selectByBlogId(blogId);
            data.get(i).setTagList(tagList);
        }
        //定义分页获取总数
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        //定义分页
        PageResp<BlogResp> pageResp = new PageResp<>();
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }

    //保存数据
    public void save(BlogReq blogReq) {
        Blog blog = CopyUtil.copy(blogReq, Blog.class);
        System.out.println(blogReq.getTagBlog());
        //增加数据
        if (ObjectUtils.isEmpty(blogReq.getBlogId())) {
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setBlogStatus(0);
            blogMapper.insertSelective(blog);
            //数组blog标签
            List<TagBlog> tagBlogList = blogReq.getTagBlog();
            //实例化一个tag类
            TagBlog tagBlog = new TagBlog();
            //获取新建的blogId
            tagBlog.setBlogId(blog.getBlogId());
            //循环插入blog标签
            for (int i = 0; i < tagBlogList.size(); i++) {
                tagBlog.setTagId(tagBlogList.get(i).getTagId());
                tagBlogMapper.insertSelective(tagBlog);
            }
        } else {
            //更新数据
            blog.setUpdateTime(new Date());
            blogMapper.updateByPrimaryKeySelective(blog);
        }
    }


    //删除数据
    public void delete(long blogId) {
        //删除数据
        blogMapper.deleteByPrimaryKey(blogId);
    }
}
