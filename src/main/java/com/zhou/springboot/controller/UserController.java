package com.zhou.springboot.controller;

import com.zhou.springboot.entity.User;
import com.zhou.springboot.service.UserService;
import com.zhou.springboot.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap();
        try {
            Map<String, String> map2 = new HashMap<>();
            User userDB = userService.login(user);
            map2.put("id", userDB.getId());
            map2.put("username", userDB.getName());
            String token = JWTUtils.getToken(map2);
            map.put("token",token);
            map.put("state","success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state","fail");
        }
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> saveUser(@RequestBody User user) {
        Map map = new HashMap();
        System.out.println("user:" + user);
        userService.save(user);
        map.put("status", "success");
        return map;
    }

    @GetMapping("/findAll")
    public Map<String, Object> findAll() {
        List<User> lists = userService.findAll();
        Map map = new HashMap();
        map.put("list", lists);
        return map;
    }
}
