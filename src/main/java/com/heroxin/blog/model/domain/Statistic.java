package com.heroxin.blog.model.domain;

import lombok.Data;

/**
 * 文章相关动态数据统计实体类
 */
@Data
public class Statistic {
    private Integer id;
    private Integer articleId;   // 评论的文章id
    private Integer hits;        // 点击量
    private Integer commentsNum;// 评论总量
}
