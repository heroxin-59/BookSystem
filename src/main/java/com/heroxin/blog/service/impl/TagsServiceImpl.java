package com.heroxin.blog.service.impl;

/*
    @Author Heroxin
    
    @Create 2023-03-25-15:57

    @Description:
*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heroxin.blog.dao.TagsMapper;
import com.heroxin.blog.model.domain.Tags;
import com.heroxin.blog.service.ITagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagsServiceImpl implements ITagsService {
    @Autowired
    private TagsMapper tagsMapper;

    @Override
    public PageInfo<Tags> selectTags(Integer page, Integer count) {
        PageHelper.startPage(page,count);
        List<Tags> tags = tagsMapper.selectTags();
        PageInfo<Tags> tagsPageInfo = new PageInfo<>(tags);
        return tagsPageInfo;
    }
}
