package com.heroxin.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heroxin.blog.dao.CommentMapper;
import com.heroxin.blog.dao.StatisticMapper;
import com.heroxin.blog.model.domain.Article;
import com.heroxin.blog.model.domain.Comment;
import com.heroxin.blog.model.domain.Statistic;
import com.heroxin.blog.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * @Classname CommentServiceImpl
 * @Description TODO
 * @Date 2019-3-14 10:15
 * @Created by CrazyStone
 */

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private StatisticMapper statisticMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    // 分页查询文章列表
    @Override
    public PageInfo<Comment> selectCommentsWithPage(Integer page, Integer count) {
        PageHelper.startPage(page,count);
        List<Comment> commentList = commentMapper.selectCommentsWithPage();
        for (int i = 0;i<commentList.size();i++) {
            Comment comment = commentList.get(i);
            Comment comment1 = commentMapper.selectCommentWithId(comment.getId());
        }
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    // 根据id查询单个评论详情，并使用Redis进行缓存管理
    public Comment selectCommentWithId(Integer id) {
        Comment comment = null;
        Object o = redisTemplate.opsForValue().get("comment_" + id);
            if(o!=null){
                comment=(Comment) o;
            }else{
                comment = commentMapper.selectCommentWithId(id);
                if(comment!=null){
                    redisTemplate.opsForValue().set("comment_" + id,comment);
                }
            }
            return comment;
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentMapper.deleteCommentById(id);
    }

    // 根据文章id分页查询评论
    @Override
    public PageInfo<Comment> getComments(Integer aid, int page, int count) {
        PageHelper.startPage(page,count);
        List<Comment> commentList = commentMapper.selectCommentWithPage(aid);
        PageInfo<Comment> commentInfo = new PageInfo<>(commentList);
        return commentInfo;
    }

    // 用户发表评论
    @Override
    public void pushComment(Comment comment){
        commentMapper.pushComment(comment);
        // 更新文章评论数据量
        Statistic statistic = statisticMapper.selectStatisticWithArticleId(comment.getArticleId());
        statistic.setCommentsNum(statistic.getCommentsNum()+1);
        statisticMapper.updateArticleCommentsWithId(statistic);
    }

}

