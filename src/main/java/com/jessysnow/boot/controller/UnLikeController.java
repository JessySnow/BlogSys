package com.jessysnow.boot.controller;

import com.jessysnow.boot.controller.result.Struct;
import com.jessysnow.boot.service.UnLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/unlike/")
@CrossOrigin
public class UnLikeController {
    private final UnLikeService unLikeService;

    @Autowired
    public UnLikeController(UnLikeService unLikeService) {
        this.unLikeService = unLikeService;
    }

    @PostMapping("")
    public Struct<Boolean> unLikeABlog(@RequestBody Map<String, String> map, HttpServletRequest request){
        return new Struct<>(unLikeService.unLikeABlog(request,
                Long.parseLong(map.get("blogId"))));
    }

    @DeleteMapping("")
    public Struct<Boolean> cancelUnlLikeBlog(@RequestBody Map<String, String> map, HttpServletRequest request){
        return new Struct<>(unLikeService.cancelUnLikeBlog(request,
                Long.parseLong(map.get("blogId"))));
    }
}
