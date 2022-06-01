package com.jessysnow.boot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 点赞表
 * userId : 点赞的用户 id
 * blogId : 被点赞的博客 id
 */
@Data
public class Like implements Serializable {
    private long userId;
    private long blogId;
}
