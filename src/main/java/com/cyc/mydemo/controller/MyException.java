package com.cyc.mydemo.controller;

import lombok.Data;

@Data
public class MyException extends Exception {
    private Integer code;
    public MyException(){}
    public MyException(Integer code , String message){
        super(message);
        this.code = code;
    }

}
