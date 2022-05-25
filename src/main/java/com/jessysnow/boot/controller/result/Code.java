package com.jessysnow.boot.controller.result;

/**
 * 全局响应码
 * 200 -- 成功
 * 201 -- 失败
 */
public enum Code {
    SUCCESS(200),
    FAIL(201);

    private int code;

    Code(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
