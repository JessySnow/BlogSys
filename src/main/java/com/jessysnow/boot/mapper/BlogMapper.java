package com.jessysnow.boot.mapper;

import com.jessysnow.boot.entity.Blog;
import com.jessysnow.boot.entity.vo.BlogWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper {

    /**
     * 从数据库中获取所有的 Blog 对象
     * @return Blog 对象集合
     */
    List<Blog> selectAll();

    /**
     * 从数据库获取所有的 Blog 对象
     * 筛选条件：用户 id
     * @return Blog 对象集合
     */
    List<Blog> selectBlogByUserId(@Param("userId")long userId);

    /**
     * 从数据库获取所有的 Blog 对象
     * 筛选条件：类别 id
     * @param categoryId 类别 id
     * @return Blog 对象集合
     */
    List<Blog> selectBlogByCategoryId(@Param("categoryIds") List<Integer> categoryId);

    /**
     * 从数据库获取所有的 Blog 对象
     * 筛选条件: 类别的名称
     * @param categoryValue 类别的名称 value
     * @return Blog 对象集合
     */
    List<BlogWrapper> selectBlogWrapperByCategoryName(@Param("categoryValue") String categoryValue);

    /**
     * 从数据库获取某一条 Blog 对象
     * 筛选条件：博客 id
     * @param id 博客 id
     * @return Blog 对象
     */
    Blog selectBlogById(@Param("id")long id);

    /**
     * 从数据库获取所有的 Blog 对象
     * 筛选条件：用户 id
     * @param userId 用户 id
     * @return Blog 对象集合
     */
    List<BlogWrapper> selectBlogWrapperByUserId(@Param("userId") long userId);

    /**
     * 从数据库筛选出 9 条 Blog 对象
     * 筛选条件：发布时间
     * @return Blog 对象集合
     */
    List<Blog> selectLastNineBlogs();

    /**
     * 从数据库筛选出 9 条 BlogWrapper 对象
     * 筛选条件：发布时间
     * @return BlogWrapper 对象
     */
    List<BlogWrapper> selectLastNineBlogWrappers();

    //TODO 插入博客的实现
    /**
     * 插入一条新的博客记录
     * @param title 标题
     * @param content 博客内容
     * @param categoryId 分类的 id
     * @param userId 用户 id
     */
    void insertANewBlog(@Param("title")String title,@Param("content")String content,@Param("categoryId")int categoryId, @Param("userId")long userId, @Param("banner")String banner);
}