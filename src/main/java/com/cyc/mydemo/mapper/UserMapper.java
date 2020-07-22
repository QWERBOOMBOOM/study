package com.cyc.mydemo.mapper;

import com.cyc.mydemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author cyc
 * @since 2020-07-21
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where id = #{id}")
    User getUserById(Long id);

    List<User> getUsersByName(@Param("userName") String userName);

}
