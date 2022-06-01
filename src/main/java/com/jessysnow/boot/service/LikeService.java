package com.jessysnow.boot.service;

import javax.servlet.http.HttpServletRequest;

public interface LikeService {
    /**
     * 为一条博客点赞
     * @param userId 用户 id
     * @param blogId 博客 id
     * @return 点赞成功 -> true
     *         点赞失败 -> false
     */
    boolean likeABlog(HttpServletRequest request, long blogId);

    /**
     * 取消为一条博客点赞
     * @param userId 用户 id
     * @param blogId 博客 id
     * @return 取消成功 -> true
     *         取消失败 -> false
     */
    boolean cancelLikeBlog(HttpServletRequest request, long blogId);
}
