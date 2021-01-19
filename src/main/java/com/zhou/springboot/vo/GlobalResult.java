package com.zhou.springboot.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GlobalResult<T> {

    private Boolean success;
    private Map<String,Object> data = new HashMap<>();
    private Integer status;
    private String msg;

    private GlobalResult(){}

    public static GlobalResult ok(){
        GlobalResult r = new GlobalResult();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setStatus(ResultCodeEnum.SUCCESS.getStatus());
        r.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        return r;
    }
    public static GlobalResult error(){
        GlobalResult r = new GlobalResult();
        r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        r.setStatus(ResultCodeEnum.UNKNOWN_ERROR.getStatus());
        r.setMsg(ResultCodeEnum.UNKNOWN_ERROR.getMsg());
        return r;
    }

    public static GlobalResult setResult(ResultCodeEnum result){
        GlobalResult r = new GlobalResult();
        r.setSuccess(result.getSuccess());
        r.setStatus(result.getStatus());
        r.setMsg(result.getMsg());
        return r;
    }
    //  使用链式编程，返回类本身
    public GlobalResult data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
    public GlobalResult data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public GlobalResult msg(String msg){
        this.setMsg(msg);
        return this;
    }
    public GlobalResult status(Integer status){
        this.setStatus(status);
        return this;
    }
    public GlobalResult success(boolean success){
        this.setSuccess(success);
        return this;
    }
}
