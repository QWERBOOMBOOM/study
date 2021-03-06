package com.cyc.mydemo.service.impl;

import com.cyc.mydemo.entity.User;
import com.cyc.mydemo.mapper.UserMapper;
import com.cyc.mydemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyc
 * @since 2020-07-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByAge(Integer leastAge, Integer maxAge) {
        return userMapper.getUserByAge(leastAge,maxAge);
    }

    @Override
    public List<User> getUserByAges(Integer leastAge, Integer maxAge) {
        return userMapper.getUserByAges(leastAge, maxAge);
    }
}
