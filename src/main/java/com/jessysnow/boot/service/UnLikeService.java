package com.jessysnow.boot.service;

import javax.servlet.http.HttpServletRequest;

public interface UnLikeService {
    /**
     * 为一条博客点踩
     * @param userId 用户 id
     * @param blogId 博客 id
     * @return 点踩成功 -> true
     *         点踩失败 -> false
     */
    boolean unLikeABlog(HttpServletRequest request, long blogId);

    /**
     * 取消为一条博客点踩
     * @param userId 用户 id
     * @param blogId 博客 id
     * @return 取消成功 -> true
     *         取消失败 -> false
     */
    boolean cancelUnLikeBlog(HttpServletRequest request, long blogId);
}
