package com.jessysnow.boot.controller;

import com.jessysnow.boot.controller.result.Code;
import com.jessysnow.boot.controller.result.Struct;
import com.jessysnow.boot.entity.Comment;
import com.jessysnow.boot.entity.User;
import com.jessysnow.boot.service.CommentService;
import com.jessysnow.boot.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @PostMapping("")
    public Struct<String> addComment(@RequestBody Map<String, String> map, HttpServletRequest request){
        User user = SessionUtil.getUserFromSession(request);
        String content = map.get("content");
        long blogId = Long.parseLong(map.get("blogId"));
        commentService.addNewComment(content, blogId, user.getId());
        return new Struct<String>(Code.SUCCESS, "评论成功");
    }
}
