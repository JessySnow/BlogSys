package com.jessysnow.boot.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class User implements Serializable {

    private long id;
    private boolean isAdmin;

    @Size(max = 50, message = "用户名过长，重新命名后重试")
    @NotNull(message = "用户名不应为空")
    private String username;

    @Size(max = 50, message = "密码过长，重新命名后重试")
    @NotNull(message = "密码不应为空")
    private String password;

    /**
     * avatar : 头像路径
     * desc : 个人简介
     */
    private String avatar;
    private String desc;
}
