package com.heroxin.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling  // 开启定时任务注解功能支持
@SpringBootApplication
public class HeroxinBlogSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroxinBlogSystemApplication.class, args);
    }

}