package com.yql.demo.controller;

import com.yql.demo.dao.UserDao;
import com.yql.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:8080")
@RestController
public class UserController {

    @Autowired
    UserDao dao;

    @PostMapping("/user/login")
    public String login(@RequestBody User user) {
        User u = null;
        String status;
        try {
            u = dao.getUser(user.getU_name());
            if (u.getU_passwd().equals(user.getU_passwd())) {
                status = u.getU_limit();
            } else {
                status = "no";
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = "no";
        }

        return status;
    }

    @PostMapping("/user/register")
    public boolean register(@RequestBody User user) {
        boolean status = true;
        try {
            dao.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    @GetMapping("/user/getall")
    public List<User> getAllUser() {
        return dao.getAllUser();
    }
}
