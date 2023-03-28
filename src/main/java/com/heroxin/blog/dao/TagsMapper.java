package com.heroxin.blog.dao;


import com.heroxin.blog.model.domain.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagsMapper {
    @Select("SELECT * FROM t_tags ORDER BY id DESC")
    public List<Tags> selectTags();
}

