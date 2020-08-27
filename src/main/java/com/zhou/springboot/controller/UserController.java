package com.zhou.springboot.controller;

import com.zhou.springboot.entity.User;
import com.zhou.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("save")
    public Map<String,Object> saveUser(@RequestBody User user){
        Map map = new HashMap();
        System.out.println("user:"+user);
        userService.save(user);
        map.put("status","success");
        return map;
    }
    @GetMapping("findAll")
    public Map<String,Object> findAll(){
        List<User> lists = userService.findAll();
        Map map = new HashMap();
        map.put("list",lists);
        return map;
    }
}
