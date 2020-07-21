package com.cyc.mydemo.controller;

import com.cyc.mydemo.entity.User;
import com.cyc.mydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Integer add(@RequestBody User user){
        return userService.save(user)?0:1;
    }
}
