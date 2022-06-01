package com.jessysnow.boot.controller;

import com.jessysnow.boot.controller.result.Code;
import com.jessysnow.boot.controller.result.Struct;
import com.jessysnow.boot.entity.Comment;
import com.jessysnow.boot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/comment/")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping({"{blogId}"})
    public Struct<List<Comment>> getSpecificComments(@PathVariable("blogId")long blogId){
        return new Struct<>(Code.SUCCESS, commentService.getCommentByBlogId(blogId));
    }
}
