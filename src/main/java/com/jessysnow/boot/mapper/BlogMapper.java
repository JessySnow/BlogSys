package com.jessysnow.boot.mapper;

import com.jessysnow.boot.entity.Blog;
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
     * 从数据库获取某一条 Blog 对象
     * 筛选条件：博客 id
     * @param id 博客 id
     * @return Blog 对象
     */
    Blog selectBlogById(@Param("id")long id);

    /**
     * 从数据库筛选出 9 条 Blog 对象
     * 筛选时间：发布时间
     * @return Blog 对象集合
     */
    List<Blog> selectLastNineBlogs();
}