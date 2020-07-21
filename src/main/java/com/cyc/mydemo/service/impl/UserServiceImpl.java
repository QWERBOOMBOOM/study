package com.cyc.mydemo.service.impl;

import com.cyc.mydemo.entity.User;
import com.cyc.mydemo.mapper.UserMapper;
import com.cyc.mydemo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cyc
 * @since 2020-07-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
