package com.zhou.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain=true)
public class User implements Serializable {

    private String id;
    private String name;
    private String age;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date bir;
    private String address;
}
