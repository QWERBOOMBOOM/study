package com.cyc.mydemo.service;

import com.cyc.mydemo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author cyc
 * @since 2020-07-21
 */
public interface UserService extends IService<User> {
    public User getUserById(Long id);

    public List<User> getUsersByName(String name);
}
