package com.heroxin.blog.dao;

/*
    @Author Heroxin
    
    @Create 2023-03-25-15:50

    @Description:
*/

import com.heroxin.blog.model.domain.Article;
import com.heroxin.blog.model.domain.Categories;
import com.heroxin.blog.model.domain.Category_Aritlle;
import com.heroxin.blog.model.domain.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select distinct content from t_categories")
    List<Categories> selectCategory();
    @Select("select * from t_categories c,t_article a where c.content = #{content} and c.id = a.id")
    List<Article> selectArtByCat(@Param("content")String content);
}
