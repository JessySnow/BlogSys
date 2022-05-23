package com.jessysnow.boot.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * id - 博客 id 自动生成
 * title - 博客标题
 * content - 博客正文
 * pubDate - 博客发布日期
 * categoryId - 博客类别标签
 * userId - 写博客的用户 id
 * count - 博客的阅读次数
 */
@Data
public class Blog implements Serializable {
    private long id;
    private String title;
    private String content;
    private Date pubDate;
    private int categoryId;
    private long userId;
    private long count;
}
