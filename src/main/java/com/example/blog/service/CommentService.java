package com.example.blog.service;

import com.example.blog.domain.Comment;
import com.example.blog.domain.CommentExample;
import com.example.blog.domain.Tag;
import com.example.blog.domain.TagExample;
import com.example.blog.mapper.CommentMapper;
import com.example.blog.mapper.TagMapper;
import com.example.blog.req.CommentReq;
import com.example.blog.req.TagReq;
import com.example.blog.resp.CommentResp;
import com.example.blog.resp.PageResp;
import com.example.blog.resp.TagResp;
import com.example.blog.util.CopyUtil;
import com.example.blog.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CommentService {
    //打印日志
    /*private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserService.class);*/
    @Resource
    public CommentMapper commentMapper;

    @Resource
    private SnowFlake snowFlake;


    public PageResp<CommentResp> list(CommentReq commentReq) {
        //固定写法
        CommentExample example = new CommentExample();
        //固定写法
        CommentExample.Criteria criteria = example.createCriteria();
        //条件查询
        //根据ID
        if (!ObjectUtils.isEmpty(commentReq.getCommentId())) {
            criteria.andCommentIdEqualTo(commentReq.getCommentId());
        }
        //分页(获取从页面传来的数据)
        PageHelper.startPage(commentReq.getPage(), commentReq.getSize());
        //类接收返回的数据
        List<Comment> commentList = commentMapper.selectByExample(example);
        //将返回的数据进行封装,某些信息是不需要返回的
        List<CommentResp> data = CopyUtil.copyList(commentList, CommentResp.class);
        //定义分页获取总数
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        //定义分页
        PageResp<CommentResp> pageResp = new PageResp<>();
        //将分页的数据进行总和
        pageResp.setTotal(pageInfo.getTotal());
        //将分页的数据加入类
        pageResp.setList(data);
        return pageResp;
    }

    //保存数据
    public void save(CommentReq commentReq) {
        Comment comment = CopyUtil.copy(commentReq, Comment.class);
        //增加数据
        if (ObjectUtils.isEmpty(commentReq.getCommentId())) {
            commentMapper.insertSelective(comment);
        } else {
            //更新数据
            commentMapper.updateByPrimaryKeySelective(comment);
        }
    }

    //删除数据
    public void delete(Long commentId) {
        //删除数据
        commentMapper.deleteByPrimaryKey(commentId);
    }
}
