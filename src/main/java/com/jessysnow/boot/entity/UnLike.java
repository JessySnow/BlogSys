package com.jessysnow.boot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 点踩表
 * userId : 点踩的用户 id
 * blogId : 被点踩的博客 id
 */
@Data
public class UnLike implements Serializable {
    private long userId;
    private long blogId;
}
