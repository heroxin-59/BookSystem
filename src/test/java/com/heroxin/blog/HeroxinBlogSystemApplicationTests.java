package com.heroxin.blog;

import com.github.pagehelper.PageInfo;
import com.heroxin.blog.model.domain.Article;
import com.heroxin.blog.model.domain.Tags;
import com.heroxin.blog.service.ICategoryService;
import com.heroxin.blog.service.ITagsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class HeroxinBlogSystemApplicationTests {
    @Autowired
    private ICategoryService categoryServiceImpl;
    @Autowired
    private ITagsService iTagsServiceImpl;

    @Test
    void contextLoads() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePass = passwordEncoder.encode("heroxin");
        System.out.println(encodePass);
        boolean matches = passwordEncoder.matches("heroxin", encodePass);
        System.out.println(matches);
    }
    @Test
    public void testCagetory(){
    }
    @Test
    public void testTags(){
        PageInfo<Tags> tags = iTagsServiceImpl.selectTags(1, 10);
        System.out.println(tags);
    }
    @Test
    public void testArtByTags(){
        PageInfo<Article> docker = iTagsServiceImpl.selectArtByTags(1, 10, "Docker");
        System.out.println(docker);
    }
    @Test
    public void testArtByCat(){
        PageInfo<Article> artByCat = categoryServiceImpl.selectArtByCat(1, 10, "笔记");
        System.out.println(artByCat);
    }



}
