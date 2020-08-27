package com.zhou.springboot;

import com.zhou.springboot.entity.User;
import com.zhou.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class springbootTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {

        List<User> list = userService.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
