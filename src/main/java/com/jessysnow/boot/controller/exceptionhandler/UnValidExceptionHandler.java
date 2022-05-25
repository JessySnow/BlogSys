package com.jessysnow.boot.controller.exceptionhandler;

import com.jessysnow.boot.controller.result.Code;
import com.jessysnow.boot.controller.result.Struct;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 对于数据校验失败的处理器
 */
@RestControllerAdvice
public class UnValidExceptionHandler{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Struct<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return new Struct<>(Code.FAIL, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

}
