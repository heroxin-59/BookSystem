package com.heroxin.blog.model.domain;

import lombok.Data;

/*
    @Author Heroxin
    
    @Create 2023-03-25-11:50

    @Description:
*/
@Data
public class Tags {
   private Integer id;
   private Integer articleId;
   private String content;

}
