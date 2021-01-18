package com.zhou.springboot.service;

import com.zhou.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();


    User login(User user);
}
