package com.zhou.springboot.service.impl;


import com.zhou.springboot.dao.UserDao;
import com.zhou.springboot.entity.User;
import com.zhou.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }


    @Override
    public User login(User user) {
        return userDAO.findUserByName(user);
    }
}
