package com.jessysnow.boot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * id - 评论 id，自动生成主键
 * blogId - 博客 id，外键引用自 Blog
 * userId - 用户 id，外键引用自 User
 * content - 评论正文
 * pubDate - 评论发布时间
 */
@Data
public class Comment implements Serializable {
    private long id;
    private long blogId;
    private long userId;
    private String content;
    private Date pubDate;
}
