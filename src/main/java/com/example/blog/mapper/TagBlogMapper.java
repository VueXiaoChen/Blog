package com.example.blog.mapper;

import com.example.blog.domain.TagBlog;
import com.example.blog.domain.TagBlogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagBlogMapper {
    long countByExample(TagBlogExample example);

    int deleteByExample(TagBlogExample example);

    int insert(TagBlog row);

    int insertSelective(TagBlog row);

    List<TagBlog> selectByExample(TagBlogExample example);

    int updateByExampleSelective(@Param("row") TagBlog row, @Param("example") TagBlogExample example);

    int updateByExample(@Param("row") TagBlog row, @Param("example") TagBlogExample example);
}