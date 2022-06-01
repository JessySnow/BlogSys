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

    /**
     * 新增一篇文章的评论
     * @param content 评论的正文
     * @param blogId 博客 id
     * @param userId 用户 id
     */
    void addNewComment(String content, long blogId, long userId);
}
