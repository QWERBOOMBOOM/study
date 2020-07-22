package com.cyc.mydemo.service;

import com.cyc.mydemo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cyc
 * @since 2020-07-22
 */
public interface UserService extends IService<User> {


    List<User> getUserByAge(Integer leastAge,Integer maxAge);

    List<User> getUserByAges(Integer leastAge,Integer maxAge);

}
