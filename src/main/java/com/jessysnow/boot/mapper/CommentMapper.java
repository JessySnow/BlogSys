package com.jessysnow.boot.mapper;

import com.jessysnow.boot.entity.Comment;
import com.jessysnow.boot.entity.vo.CommentWrapper;
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

    /**
     * 从数据库获取某一篇博客的所有评论
     * @param blogId 博客的 id
     * @return CommentWrapper 对象集合
     */
    List<CommentWrapper> selectCommentWrapperByBlogId(@Param("blogId") long blogId);

    /**
     * 向数据库插入一条新的评论
     * @param content 评论正文
     * @param blogId 博客 id
     */
    void insertNewComment(@Param("content")String content,@Param("blogId") long blogId,@Param("userId") long userId);

}
