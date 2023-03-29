package com.heroxin.blog.service;

/*
    @Author Heroxin
    
    @Create 2023-03-28-19:45

    @Description:
*/

import com.github.pagehelper.PageInfo;
import com.heroxin.blog.model.domain.User;

import java.util.List;

public interface IUserService {
    PageInfo<User> selectUser(Integer page, Integer count);
}
