package com.jessysnow.boot.controller.result;

import lombok.Getter;

/**
 * 统一返回体z
 */
@Getter
public class Struct<T> {

    // 响应码
    private int code;

    // 响应数据
    private T data;

    public Struct(T data){
        this(Code.SUCCESS, data);
    }

    public Struct(Code code, T data){
        this.code = code.getCode();
        this.data = data;
    }
}
