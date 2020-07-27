package com.cyc.mydemo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cyc.mydemo.entity.MyUserDetail;
import com.cyc.mydemo.entity.User;
import com.cyc.mydemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MyCustomUserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public MyUserDetail loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getName, userName));
        if (Objects.nonNull(user)){
            MyUserDetail userDetails = new MyUserDetail();
            userDetails.setUsername(userName);
            userDetails.setPassword(user.getPassword());
            return userDetails;
        }
        return null;
    }
}
