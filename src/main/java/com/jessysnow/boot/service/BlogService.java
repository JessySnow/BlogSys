package com.jessysnow.boot.service;

import com.jessysnow.boot.entity.Blog;

import java.util.List;

public interface BlogService {
    /**
     * 获取所有的博客
     * @return Blog 集合对象
     */
    List<Blog> getAll();
}
