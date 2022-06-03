package com.jessysnow.boot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 对博客对象进行封装，新增了博客的分类字段
 * 删除了部分不需要的数据
 */
@Data
public class BlogWrapper implements Serializable {
    private long id;
    private String title;
    private Date pubDate;
    private String content;
    private long userId;
    private long count;
    private String banner;
    private String value;
}
