package com.cyc.mydemo.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 接收基本操作的前端返回类
 */
@Data
public class UserVO {
    private Long id;
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "密码不能为空")
    private String password;

    private String salt;
}
