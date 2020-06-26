package com.yql.demo.service;

import com.yql.demo.dao.UserDao;
import com.yql.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public String login(@RequestBody User user) {
        User u = null;
        String status;
        try {
            u = userDao.getUser(user.getU_name());
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

    public boolean register(@RequestBody User user) {
        boolean status = true;
        try {
            userDao.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
