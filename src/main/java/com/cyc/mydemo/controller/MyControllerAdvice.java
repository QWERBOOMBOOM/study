package com.cyc.mydemo.controller;

import com.cyc.mydemo.config.MyException;
import com.cyc.mydemo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
@Slf4j
public class MyControllerAdvice {
    @ExceptionHandler(MyException.class)
    public Result exceptionResult(MyException e, WebRequest webRequest){
        log.info("错误信息是:{},{}",e,webRequest);
        return new Result(e.getCode(),e.getMessage());
    }
}
