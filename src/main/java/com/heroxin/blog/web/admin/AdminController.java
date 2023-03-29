package com.heroxin.blog.web.admin;

import com.github.pagehelper.PageInfo;
import com.heroxin.blog.model.ResponseData.ArticleResponseData;
import com.heroxin.blog.model.ResponseData.CommentResponseData;
import com.heroxin.blog.model.ResponseData.StaticticsBo;
import com.heroxin.blog.model.domain.*;
import com.heroxin.blog.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname AdminController
 * @Description 后台管理模块
 * @Date 2019-3-14 10:39
 * @Created by CrazyStone
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ISiteService siteServiceImpl;
    @Autowired
    private IArticleService articleServiceImpl;
    @Autowired
    private ICommentService commentServiceImpl;
    @Autowired
    private ICategoryService categoryServiceImpl;
    @Autowired
    private ITagsService iTagsServiceImpl;
    @Autowired
    private IUserService userService;

    // 管理中心起始页
    @GetMapping(value = {"", "/index"})
    public String index(HttpServletRequest request) {
        // 获取最新的5篇博客、评论以及统计数据
        List<Article> articles = siteServiceImpl.recentArticles(5);
        List<Comment> comments = siteServiceImpl.recentComments(5);
        StaticticsBo staticticsBo = siteServiceImpl.getStatistics();
        // 向Request域中存储数据
        request.setAttribute("comments", comments);
        request.setAttribute("articles", articles);
        request.setAttribute("statistics", staticticsBo);
        return "back/index";
    }

    // 向文章发表页面跳转
    @GetMapping(value = "/article/toEditPage")
    public String newArticle() {
        return "back/article_edit";
    }

    // 发表文章
    @PostMapping(value = "/article/publish")
    @ResponseBody
    public ArticleResponseData publishArticle(Article article) {
        if (StringUtils.isBlank(article.getCategories())) {
            article.setCategories("默认分类");
        }
        try {
            articleServiceImpl.publish(article);
            logger.info("文章发布成功");
            return ArticleResponseData.ok();
        } catch (Exception e) {
            logger.error("文章发布失败，错误信息: " + e.getMessage());
            return ArticleResponseData.fail();
        }
    }

    // 跳转到后台文章列表页面
    @GetMapping(value = "/article")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "count", defaultValue = "10") int count,
                        HttpServletRequest request) {
        PageInfo<Article> pageInfo = articleServiceImpl.selectArticleWithPage(page, count);
        request.setAttribute("articles", pageInfo);
        return "back/article_list";
    }


    // 跳转到后台评论列表页面
    @GetMapping(value = "/comment")
    public String comment(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "count", defaultValue = "10") int count,
                          HttpServletRequest request) {
        PageInfo<Comment> pageInfo = commentServiceImpl.selectCommentsWithPage(page, count);
        request.setAttribute("comment", pageInfo);
        return "back/comment_list";
    }

    // 跳转到分类页面
    @GetMapping(value = "/category")
    public String category(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "count", defaultValue = "10") int count,
                          HttpServletRequest request) {
        PageInfo<Categories> categories = categoryServiceImpl.selectCategory(page, count);
        request.setAttribute("category", categories);
        return "back/category_list";
    }
    // 跳转到标签页面
    @GetMapping(value = "/tag")
    public String tag(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "count", defaultValue = "10") int count,
                          HttpServletRequest request) {
        PageInfo<Tags> tags = iTagsServiceImpl.selectTags(page, count);
        request.setAttribute("tag", tags);
        return "back/tag_list";
    }
    // 跳转到标签-文章页面
    @GetMapping(value = "/tag/art/{content}")
    public String tagArt(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "count", defaultValue = "10") int count,
                          @PathVariable String content,
                          HttpServletRequest request) {
        PageInfo<Article> articlePageInfo = iTagsServiceImpl.selectArtByTags(page, count, content);
        request.setAttribute("artTag", articlePageInfo);
        return "back/tag_art_list";
    }
    // 跳转到分类-文章页面
    @GetMapping(value = "/category/art/{content}")
    public String catArt(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "count", defaultValue = "10") int count,
                          @PathVariable String content,
                          HttpServletRequest request) {
        PageInfo<Article> artByCat = categoryServiceImpl.selectArtByCat(page, count, content);
        request.setAttribute("catTag", artByCat);
        return "back/category_art_list";
    }
    // 跳转到用户列表页面
    @GetMapping(value = "/userList")
    public String userController(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "count", defaultValue = "10") int count,
                          HttpServletRequest request) {
        PageInfo<User> userPageInfo = userService.selectUser(page, count);
        request.setAttribute("user", userPageInfo);
        return "back/user_list";
    }

    // 向文章修改页面跳转
    @GetMapping(value = "/article/{id}")
    public String editArticle(@PathVariable("id") String id, HttpServletRequest request) {
        Article article = articleServiceImpl.selectArticleWithId(Integer.parseInt(id));
        request.setAttribute("contents", article);
        request.setAttribute("categories", article.getCategories());
        return "back/article_edit";
    }


    // 文章修改处理
    @PostMapping(value = "/article/modify")
    @ResponseBody
    public ArticleResponseData modifyArticle(Article article) {
        try {
            articleServiceImpl.updateArticleWithId(article);
            logger.info("文章更新成功");
            return ArticleResponseData.ok();
        } catch (Exception e) {
            logger.error("文章更新失败，错误信息: " + e.getMessage());
            return ArticleResponseData.fail();
        }
    }

    // 文章删除
    @PostMapping(value = "/article/delete")
    @ResponseBody
    public ArticleResponseData delete(@RequestParam int id) {
        try {
            articleServiceImpl.deleteArticleWithId(id);
            logger.info("文章删除成功");
            return ArticleResponseData.ok();
        } catch (Exception e) {
            logger.error("文章删除失败，错误信息: " + e.getMessage());
            return ArticleResponseData.fail();
        }
    }

    // 评论删除
    @PostMapping(value = "/comment/delete")
    @ResponseBody
    public CommentResponseData deleteComment(@RequestParam int id) {
        try {
            commentServiceImpl.deleteCommentById(id);
            logger.info("评论删除成功");
            return CommentResponseData.ok();
        } catch (Exception e) {
            logger.error("评论删除失败，错误信息: " + e.getMessage());
            return CommentResponseData.fail();
        }
    }


}

