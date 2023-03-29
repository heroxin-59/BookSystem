package com.heroxin.blog.dao;


import com.heroxin.blog.model.domain.Article;
import com.heroxin.blog.model.domain.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagsMapper {
    @Select("select distinct content from t_tags")
    public List<Tags> selectTags();

    @Select("select * from t_tags t, t_article a where t.content = #{content} and t.article_id = a.id")
    List<Article> selectArtByTags(@Param("content") String content);
}

