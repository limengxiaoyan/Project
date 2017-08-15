package com.magicbeans.config;

/**
 * 进行统一的异常处理
 */
//@ControllerAdvice
public class GlobalExceptionHandler {


//    @ExceptionHandler(value = Exception.class)
    public String exception() {
        return "error";
    }
}
