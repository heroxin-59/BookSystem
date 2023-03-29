package com.heroxin.blog.dao;

/*
    @Author Heroxin
    
    @Create 2023-03-28-19:44

    @Description:
*/

import com.heroxin.blog.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    List<User> selectUser();
}
