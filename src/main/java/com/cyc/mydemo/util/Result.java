package com.cyc.mydemo.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class Result<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Result(Integer code){
        this.code = code;

    }
    public Result(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public Result(Integer code,T data){
        this.code = code;
        this.data = data;
    }
    public static Result<Object> success(Object o){
        return  new Result<>(0,"success",o);
    }
    public static Result<Object> fail(Object o){

        log.error("错误信息是:{}",o);
        return new Result<>(1,"fail",o);

    }
}
