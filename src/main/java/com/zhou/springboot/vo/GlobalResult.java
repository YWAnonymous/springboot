package com.zhou.springboot.vo;

import lombok.Data;

@Data
public class GlobalResult<T> {

    private T data;
    private Integer status;
    private String msg;

    public GlobalResult(){}

    public GlobalResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    public GlobalResult(T data,Integer status,String msg){
        this.data = data;
        this.msg = msg;
        this.status = status;
    }
    public GlobalResult(T data){
        this.data = data;
    }

}
