package com.gltedu.exception;

import com.gltedu.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 巩乐天
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获异常
    public Result ex(Exception ex){
         return Result.error("对不起 操作失败");
     }
}
