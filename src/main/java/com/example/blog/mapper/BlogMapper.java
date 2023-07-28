package com.example.blog.mapper;

import com.example.blog.domain.Blog;
import com.example.blog.domain.BlogExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Long blogId);

    int insert(Blog row);

    int insertSelective(Blog row);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Long blogId);

    int updateByExampleSelective(@Param("row") Blog row, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("row") Blog row, @Param("example") BlogExample example);

    int updateByExample(@Param("row") Blog row, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog row);

    int updateByPrimaryKeyWithBLOBs(Blog row);

    int updateByPrimaryKey(Blog row);
}