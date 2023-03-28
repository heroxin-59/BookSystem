package com.heroxin.blog.service;

import com.github.pagehelper.PageInfo;
import com.heroxin.blog.model.domain.Article;
import com.heroxin.blog.model.domain.Comment;

/**
 * @Classname ICommentService
 * @Description 文章评论业务处理接口
 * @Date 2019-3-14 10:13
 * @Created by CrazyStone
 */
public interface ICommentService {
    // 分页查询文章列表
    public PageInfo<Comment> selectCommentsWithPage(Integer page, Integer count);

//    根据评论 id 查询 单个评论详情
    public Comment selectCommentWithId(Integer id);

//    根据评论 id 删除评论
    public void deleteCommentById(Integer id);

    // 获取文章下的评论
    public PageInfo<Comment> getComments(Integer aid, int page, int count);

    // 用户发表评论
    public void pushComment(Comment comment);

}

