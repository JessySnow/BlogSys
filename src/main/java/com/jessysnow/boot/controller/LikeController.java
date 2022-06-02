package com.jessysnow.boot.controller;

import com.jessysnow.boot.controller.result.Struct;
import com.jessysnow.boot.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/like/")
@CrossOrigin
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("")
    public Struct<Boolean> likeABlog(@RequestBody Map<String, String> map, HttpServletRequest request){
        return new Struct<>(likeService.likeABlog(request,
                            Long.parseLong(map.get("blogId"))));
    }

    @DeleteMapping("")
    public Struct<Boolean> cancelLikeBlog(@RequestBody Map<String, String> map, HttpServletRequest request){
        return new Struct<>(likeService.cancelLikeBlog(request,
                Long.parseLong(map.get("blogId"))));
    }

    @GetMapping("{blogId}")
    public Struct<Long> getBlogLikeCount(@PathVariable("blogId") Long blogId){
        return new Struct<>(likeService.getBlogLikeCount(blogId));
    }
}
