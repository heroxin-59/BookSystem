package com.heroxin.blog.dao;

/*
    @Author Heroxin
    
    @Create 2023-03-25-15:50

    @Description:
*/

import com.heroxin.blog.model.domain.Categories;
import com.heroxin.blog.model.domain.Category_Aritlle;
import com.heroxin.blog.model.domain.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("SELECT * FROM t_categories ORDER BY id DESC")
    public List<Categories> selectCategory();
//
//    @Select("select GROUP_CONCAT(title),t_categories.content from t_article,t_categories where t_article.id = t_categories.id GROUP BY t_categories.content")
//    public List<Category_Aritlle> selectCategory();
}
