package com.heroxin.blog.model.domain;

/*
    @Author Heroxin
    
    @Create 2023-03-28-19:43

    @Description:
*/

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Date created;
    private Integer valid;
}
