package com.example.blog.mapper;

import com.example.blog.domain.RedisTest;
import com.example.blog.domain.RedisTestExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RedisTestMapper {
    long countByExample(RedisTestExample example);

    int deleteByExample(RedisTestExample example);

    int deleteByPrimaryKey(Integer redisid);

    int insert(RedisTest row);

    int insertSelective(RedisTest row);

    List<RedisTest> selectByExample(RedisTestExample example);

    RedisTest selectByPrimaryKey(Integer redisid);

    int updateByExampleSelective(@Param("row") RedisTest row, @Param("example") RedisTestExample example);

    int updateByExample(@Param("row") RedisTest row, @Param("example") RedisTestExample example);

    int updateByPrimaryKeySelective(RedisTest row);

    int updateByPrimaryKey(RedisTest row);
}