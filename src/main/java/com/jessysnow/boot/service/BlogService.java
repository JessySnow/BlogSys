package com.jessysnow.boot.service;

import com.jessysnow.boot.entity.Blog;
import com.jessysnow.boot.entity.vo.BlogWrapper;

import javax.servlet.http.HttpServletRequest;
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
     * @return BlogWrapper 对象集合
     */
    List<BlogWrapper> getLastNineBlogWrappers();

    /**
     * 获取用户的所有博客
     * @return BlogWrapper 对象集合
     */
    List<BlogWrapper> getUserBlogs(long userId);

    /**
     * 根据 id 获取 Blog
     * @param id 博客 id
     * @return Blog 对象
     */
    Blog getBlogById(long id);


    void pubANewBlog(String title, String content, int categoryId, HttpServletRequest request);
}
