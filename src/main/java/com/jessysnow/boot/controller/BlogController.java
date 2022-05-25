package com.jessysnow.boot.controller;

import com.jessysnow.boot.controller.result.Code;
import com.jessysnow.boot.controller.result.Struct;
import com.jessysnow.boot.entity.Blog;
import com.jessysnow.boot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/blog/")
public class BlogController {
//
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public Struct<List<Blog>> BlogList(){
        return new Struct<>(Code.SUCCESS, blogService.getLastNineBlogs());
    }

    @GetMapping("test")
    public Struct<Blog> test(){
        return new Struct<>(Code.SUCCESS, blogService.getBlogById(1));
    }

}
