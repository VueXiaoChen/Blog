package com.example.blog.mapper;

import com.example.blog.domain.BlogType;
import com.example.blog.domain.BlogTypeExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogTypeMapper {
    long countByExample(BlogTypeExample example);

    int deleteByExample(BlogTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(BlogType row);

    int insertSelective(BlogType row);

    List<BlogType> selectByExample(BlogTypeExample example);

    BlogType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("row") BlogType row, @Param("example") BlogTypeExample example);

    int updateByExample(@Param("row") BlogType row, @Param("example") BlogTypeExample example);

    int updateByPrimaryKeySelective(BlogType row);

    int updateByPrimaryKey(BlogType row);
}