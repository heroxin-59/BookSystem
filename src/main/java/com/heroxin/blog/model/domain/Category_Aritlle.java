package com.heroxin.blog.model.domain;

/*
    @Author Heroxin
    
    @Create 2023-03-26-9:07

    @Description:
*/

import lombok.Data;

import java.util.List;

@Data
public class Category_Aritlle {
   private List<String> title;
   private String content;
}
