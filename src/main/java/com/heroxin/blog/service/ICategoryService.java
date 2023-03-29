package com.heroxin.blog.service;

/*
    @Author Heroxin
    
    @Create 2023-03-25-15:59

    @Description:
*/

import com.github.pagehelper.PageInfo;
import com.heroxin.blog.model.domain.Article;
import com.heroxin.blog.model.domain.Categories;

import java.util.List;

public interface ICategoryService {
    public PageInfo<Categories> selectCategory(Integer page, Integer count);
    PageInfo<Article> selectArtByCat(Integer page,Integer count,String content);

}
