package com.zhou.springboot.service;

import com.zhou.springboot.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User login(User user);
}
