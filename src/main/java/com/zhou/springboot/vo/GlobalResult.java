package com.zhou.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResult implements Serializable {

    private Object data;
    private Integer status;
    private String msg;
    private Map<Object, Object> meta;

    public GlobalResult(Integer status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }
    public GlobalResult(Integer status, String msg,Object data){
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

}
