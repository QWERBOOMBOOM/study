package com.cyc.mydemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyc.mydemo.config.MyException;
import com.cyc.mydemo.entity.User;
import com.cyc.mydemo.entity.vo.UserAddVO;
import com.cyc.mydemo.service.UserService;
import com.cyc.mydemo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UserService userService;

    /**
     * 增加用户
     * @param user
     * @return
     * @throws MyException
     */
    @PostMapping("/add")
    public Result add(@RequestBody @Valid UserAddVO user) throws MyException {

        if ( userService.count(new LambdaQueryWrapper<User>().eq(User::getName,user.getName()))>1){
            throw new MyException(0001,"已经存在用户");
        }
        User addUser = new User();
        addUser.setName(user.getName())
                .setPassword(user.getPassword())
                .setSalt(user.getSalt())
                .setCreateTime(new Date());
        if (!userService.save(addUser)){
            throw new MyException(0002,"添加用户失败");
        }
        return Result.success("添加成功");
    }

    /**
     * 根据用户名称查询
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    public Result getUser(@PathVariable String name){

        return Result.success(userService.getOne(new LambdaQueryWrapper<User>()
        .like(User::getName,name)));
    }

    /**
     * 修改用户
     * @param vo
     * @return
     */
    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody @Valid UserAddVO vo){
        User user = new User()
                .setId(vo.getId())
                .setName(vo.getName())
                .setSalt(vo.getSalt())
                .setPassword(vo.getPassword())
                .setUpdateTime(new Date());
        Boolean result = userService.update(user,new UpdateWrapper<User>());
        return Result.success(result?"修改成功":"修改失败");
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @GetMapping("/page")
    public Result page(Page<User> page){
        IPage<User> resultPage = userService.page(page);
        return Result.success(resultPage);
    }
}
