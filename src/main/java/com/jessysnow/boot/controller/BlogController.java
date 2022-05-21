package com.jessysnow.boot.controller;

import com.jessysnow.boot.entity.Blog;
import com.jessysnow.boot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/blog/")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Blog> BlogList(){
        return blogService.getAll();
    }

    @GetMapping("test")
    @ResponseBody
    public Blog test(){
        Blog blog = new Blog();
        blog.setId(1);
        blog.setCategoryId(1);
        blog.setUserId(1);
        blog.setContent("这是一篇测试博客的内容");
        blog.setTitle("这是一篇测试博客的标题");
        return blog;
    }

}
