package com.heroxin.blog.service.impl;

/*
    @Author Heroxin
    
    @Create 2023-03-28-19:46

    @Description:
*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heroxin.blog.dao.UserMapper;
import com.heroxin.blog.model.domain.User;
import com.heroxin.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageInfo<User> selectUser(Integer page, Integer count) {
        PageHelper.startPage(page,count);
        List<User> users = userMapper.selectUser();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }
}
