package com.heroxin.blog.service.impl;

/*
    @Author Heroxin
    
    @Create 2023-03-25-15:59

    @Description:
*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heroxin.blog.dao.CategoryMapper;
import com.heroxin.blog.model.domain.Article;
import com.heroxin.blog.model.domain.Categories;
import com.heroxin.blog.model.domain.Category_Aritlle;
import com.heroxin.blog.model.domain.Statistic;
import com.heroxin.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageInfo<Categories> selectCategory(Integer page, Integer count) {
        PageHelper.startPage(page,count);
        List<Categories> categoriesList = categoryMapper.selectCategory();
        PageInfo<Categories> pageInfo = new PageInfo<>(categoriesList);
        return pageInfo;
    }

}
