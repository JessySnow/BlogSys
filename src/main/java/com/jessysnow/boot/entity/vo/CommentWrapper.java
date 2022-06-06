package com.jessysnow.boot.entity.vo;

import com.jessysnow.boot.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CommentWrapper implements Serializable {
    private String content;
    private Date pubDate;
    private User user;
}
