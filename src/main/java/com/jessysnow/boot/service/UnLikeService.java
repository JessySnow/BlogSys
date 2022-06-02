package com.jessysnow.boot.service;

import com.jessysnow.boot.entity.Like;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UnLikeService {
    /**
     * 为一条博客点踩
     * @param blogId 博客 id
     * @return 点踩成功 -> true
     *         点踩失败 -> false
     */
    boolean unLikeABlog(HttpServletRequest request, long blogId);

    /**
     * 取消为一条博客点踩
     * @param blogId 博客 id
     * @return 取消成功 -> true
     *         取消失败 -> false
     */
    boolean cancelUnLikeBlog(HttpServletRequest request, long blogId);

    /**
     * 获取某一个博客的点踩数量
     * @param blogId 博客的 id
     * @return long 博客的获踩数量
     */
    long getBlogUnLikeCount(long blogId);
}
