package com.zhou.springboot.dao;

import com.zhou.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {
    //查询所有用户
    List<User> findAll();
    //保存用户
    void save(User user);
}
