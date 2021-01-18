package com.zhou.springboot.controller;

import com.zhou.springboot.entity.User;
import com.zhou.springboot.service.UserService;
import com.zhou.springboot.utils.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@Slf4j
@Api()
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation("aa")
    public Map<String, Object> login(User user) {
        log.info("username"+user.getUsername());
        Map<String, Object> map = new HashMap();
        try {
            Map<String, String> map2 = new HashMap<>();
            User userDB = userService.login(user);
            map2.put("id", userDB.getId());
            map2.put("username", userDB.getUsername());
            String token = JWTUtils.getToken(map2);
            map.put("token",token);
            map.put("status","200");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status","100");
        }
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
