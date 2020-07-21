package com.cyc.mydemo.controller;

import com.cyc.mydemo.entity.User;
import com.cyc.mydemo.service.UserService;
import com.cyc.mydemo.util.Result;
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
    public Result add(@RequestBody User user) throws MyException {
        if (!userService.save(user)){
            throw new MyException(111,"添加用户失败");
        }
        return Result.success("添加成功");
    }
}
