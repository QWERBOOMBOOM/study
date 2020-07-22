package com.cyc.mydemo.controller;

import com.cyc.mydemo.config.MyException;
import com.cyc.mydemo.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class MyControllerAdvice {
    @ExceptionHandler(MyException.class)
    public Result exceptionResult(MyException e){
        return new Result(e.getCode(),e.getMessage());
    }
}
