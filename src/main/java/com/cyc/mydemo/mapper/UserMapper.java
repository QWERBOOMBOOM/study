package com.cyc.mydemo.mapper;

import com.cyc.mydemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cyc
 * @since 2020-07-22
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where age between #{leastAge} and #{maxAge}" )
    List<User> getUserByAge(@Param("leastAge") Integer leastAge, @Param("maxAge")Integer maxAge);

    List<User> getUserByAges(@Param("leastAge") Integer leastAge, @Param("maxAge")Integer maxAge);

}
