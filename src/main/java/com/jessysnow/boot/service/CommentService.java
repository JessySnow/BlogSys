package com.jessysnow.boot.service;

import com.jessysnow.boot.entity.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 获取某一篇博客的评论
     * @param blogId 博客 id
     * @return 博客的所有评论
     */
    List<Comment> getCommentByBlogId(long blogId);
}
