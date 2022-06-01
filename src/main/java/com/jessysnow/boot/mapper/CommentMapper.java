package com.jessysnow.boot.mapper;

import com.jessysnow.boot.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    /**
     * 从数据库获取某一篇博客的所有评论
     * @param blogId 博客的 id
     * @return Comment 对象集合
     */
    List<Comment> selectCommentByBlogId(@Param("blogId") long blogId);
}
