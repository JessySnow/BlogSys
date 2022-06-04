package com.jessysnow.boot.controller;

import com.jessysnow.boot.controller.result.Code;
import com.jessysnow.boot.controller.result.Struct;
import com.jessysnow.boot.entity.Blog;
import com.jessysnow.boot.entity.vo.BlogWrapper;
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
    public Struct<List<BlogWrapper>> BlogList(){
        return new Struct<>(Code.SUCCESS, blogService.getLastNineBlogWrappers());
    }

    @GetMapping("test")
    public Struct<Blog> test(){
        return new Struct<>(Code.SUCCESS, blogService.getBlogById(1));
    }

    @GetMapping({"{id}"})
    public Struct<Blog> getSpecificBlog(@PathVariable(name = "id") long id){
        return new Struct<>(Code.SUCCESS, blogService.getBlogById(id));
    }
}
