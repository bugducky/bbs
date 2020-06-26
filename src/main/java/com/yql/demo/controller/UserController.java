package com.yql.demo.controller;

import com.yql.demo.entity.User;
import com.yql.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:8080")
@RestController
public class UserController {

    @Autowired
    UserService us;

    @PostMapping("/user/login")
    public String login(@RequestBody User user) {
        return us.login(user);
    }

    @PostMapping("/user/register")
    public boolean register(@RequestBody User user) {

        return us.register(user);
    }

    @GetMapping("/user/getall")
    public List<User> getAllUser() {
        return us.getAllUser();
    }

    @PostMapping("/user/update")
    public void updateUser(@RequestBody User user) {
        us.updateUser(user);
    }
}
