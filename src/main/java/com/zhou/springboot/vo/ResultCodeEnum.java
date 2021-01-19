package com.zhou.springboot.vo;


import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(true,200,"交易成功"),
    UNKNOWN_ERROR(false,100,"交易失败");


    private Boolean success;
    private Integer status;
    private String msg;

    ResultCodeEnum(boolean success,Integer status,String msg){
        this.success = success;
        this.status = status;
        this.msg = msg;
    }
}
