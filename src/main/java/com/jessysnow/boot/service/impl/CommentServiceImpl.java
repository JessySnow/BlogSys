package com.jessysnow.boot.service.impl;

import com.jessysnow.boot.entity.Comment;
import com.jessysnow.boot.mapper.CommentMapper;
import com.jessysnow.boot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> getCommentByBlogId(long blogId) {
        return commentMapper.selectCommentByBlogId(blogId);
    }
}
