package com.jessysnow.boot.service;

import com.jessysnow.boot.entity.Blog;

import java.util.List;

public interface BlogService {
    /**
     * 获取所有的博客
     * @return Blog 集合对象
     */
    List<Blog> getAll();

    /**
     * 获取最新的 9 条博客
     * @return Blog 集合对象
     */
    List<Blog> getLastNineBlogs();

    /**
     * 获取最新的 9 条博客包装对象
     * @return BlogWrapper 对象
     */
    List<Blog> getLastNineBlogWrappers();

    /**
     * 根据 id 获取 Blog
     * @param id 博客 id
     * @return Blog 对象
     */
    Blog getBlogById(long id);
}
