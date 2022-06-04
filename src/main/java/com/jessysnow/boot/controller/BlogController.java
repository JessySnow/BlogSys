package com.jessysnow.boot.controller;

import com.jessysnow.boot.controller.result.Code;
import com.jessysnow.boot.controller.result.Struct;
import com.jessysnow.boot.entity.Blog;
import com.jessysnow.boot.entity.vo.BlogWrapper;
import com.jessysnow.boot.service.BlogService;
import com.jessysnow.boot.service.CategoryService;
import com.jessysnow.boot.utils.FlexMarkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/blog/")
public class BlogController {
    private final BlogService blogService;
    private final CategoryService categoryService;

    @Autowired
    public BlogController(BlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
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

    @PostMapping("")
    public Struct<String> pubANewBlog(@RequestBody BlogWrapper blogWrapper, HttpServletRequest httpServletRequest){
        int categoryId = categoryService.addOrGetCategory(blogWrapper.getValue());
        blogService.pubANewBlog(blogWrapper.getTitle(), FlexMarkUtil.parseMarkDown(blogWrapper.getContent()), categoryId, httpServletRequest);
        return new Struct<>("发布成功");
    }
}
