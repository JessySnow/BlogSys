package com.jessysnow.boot.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class Blog implements Serializable {
    private long id;
    private String title;
    private String content;
    private Date pubDate;
    private int categoryId;
    private long userId;
}
