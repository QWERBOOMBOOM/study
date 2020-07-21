package com.cyc.mydemo.util;

import lombok.Data;

import java.io.Serializable;

@Data
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
    public static Result success(Object o){
        return  new Result<>(0,"success",o);
    }
}
