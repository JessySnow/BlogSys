package com.jessysnow.boot.entity;

import lombok.Data;

/**
 * 点赞表
 * userId : 点赞的用户 id
 * blogId : 被点赞的博客 id
 */
@Data
public class Like {
    private long userId;
    private long blogId;
}
