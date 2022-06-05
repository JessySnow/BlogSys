package com.jessysnow.boot.controller.exceptionhandler;

import com.jessysnow.boot.controller.result.Code;
import com.jessysnow.boot.controller.result.Struct;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

/**
 * 全局异常捕获
 */
@RestControllerAdvice
public class UnValidExceptionHandler{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Struct<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return new Struct<>(Code.FAIL, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public Struct<String> NullPointerExceptionHandler(){
        return new Struct<>(Code.FAIL, "Oops, 好像出了点问题，请检查是否已经登录，或者提交的信息是否完整");
    }

    @ExceptionHandler(MultipartException.class)
    public Struct<String> MultipartException(){
        return new Struct<>(Code.FAIL, "Oops, 好像出了点问题，请检查是否已经登录，或者提交的信息是否完整");
    }
}
