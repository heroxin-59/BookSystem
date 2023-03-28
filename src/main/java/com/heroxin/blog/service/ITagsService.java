package com.heroxin.blog.service;

/*
    @Author Heroxin
    
    @Create 2023-03-25-15:57

    @Description:
*/

import com.github.pagehelper.PageInfo;
import com.heroxin.blog.model.domain.Tags;

import java.util.List;

public interface ITagsService {

    public PageInfo<Tags> selectTags(Integer page,Integer count);

}
