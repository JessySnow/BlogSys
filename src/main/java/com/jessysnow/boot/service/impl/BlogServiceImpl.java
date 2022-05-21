package com.jessysnow.boot.service.impl;

import com.jessysnow.boot.entity.Blog;
import com.jessysnow.boot.mapper.BlogMapper;
import com.jessysnow.boot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;

    @Autowired
    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public List<Blog> getAll() {
        return blogMapper.selectAll();
    }
}
