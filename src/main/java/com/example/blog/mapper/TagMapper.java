package com.example.blog.mapper;

import com.example.blog.domain.Tag;
import com.example.blog.domain.TagExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag row);

    int insertSelective(Tag row);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByExampleSelective(@Param("row") Tag row, @Param("example") TagExample example);

    int updateByExample(@Param("row") Tag row, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag row);

    int updateByPrimaryKey(Tag row);

    List<Tag> selectByBlogId(Integer blogId);
}