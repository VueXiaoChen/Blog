package com.example.blog.mapper;

import com.example.blog.domain.Comment;
import com.example.blog.domain.CommentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Long commentId);

    int insert(Comment row);

    int insertSelective(Comment row);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Long commentId);

    int updateByExampleSelective(@Param("row") Comment row, @Param("example") CommentExample example);

    int updateByExample(@Param("row") Comment row, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment row);

    int updateByPrimaryKey(Comment row);
}