package com.cyc.cloud.user.service.impl;

import com.cyc.cloud.user.entity.User;
import com.cyc.cloud.user.mapper.UserMapper;
import com.cyc.cloud.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hsf
 * @since 2020-07-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
