package com.jessysnow.boot.service;

import com.jessysnow.boot.entity.Banner;
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


    /**
     * 发布一条新博客
     * @param title 博客标题
     * @param content 博客正文
     * @param categoryId 博客 id
     */
    void pubANewBlog(String title, String content, int categoryId, HttpServletRequest request, String categoryValue);

    /**
     * 通过标签搜索博客
     * @param category 分类标签的值
     * @return BlogWrapper 对象集合
     */
    List<BlogWrapper> getBlogByCategoryValue(String category);

    /**
     * 随机选择一张图片作为 Blog 的 Banner
     * @param categoryValue 图片的分类值
     * @return Banner 对象集合
     */
    Banner chooseABanner(String categoryValue);
}
