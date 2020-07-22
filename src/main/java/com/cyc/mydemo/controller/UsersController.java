package com.cyc.mydemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyc.mydemo.config.MyException;
import com.cyc.mydemo.entity.User;
import com.cyc.mydemo.entity.vo.UserVO;
import com.cyc.mydemo.service.UserService;
import com.cyc.mydemo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
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
    public Result add(@RequestBody @Valid UserVO user) throws MyException {

        if ( userService.count(new LambdaQueryWrapper<User>().eq(User::getName,user.getName()))>1){
            throw new MyException(0001,"已经存在用户");
        }
        User addUser = new User();
        addUser.setName(user.getName())
                .setPassword(user.getPassword())
                .setSalt(user.getSalt())
                .setAge(user.getAge())
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
    public Result updateUser(@RequestBody @Valid UserVO vo){
        User user = new User()
                .setId(vo.getId())
                .setName(vo.getName())
                .setSalt(vo.getSalt())
                .setPassword(vo.getPassword())
                .setAge(vo.getAge())
                .setUpdateTime(new Date());
        Boolean result = userService.update(user,new UpdateWrapper<User>());
        return Result.success(result?"修改成功":"修改失败");
    }

    /**
     * 分页查询
     * @param size
     * @return
     */
    @GetMapping("/page")
    public Result page(@RequestParam("size")Integer size,@RequestParam("current")Integer current){
        Page<User> page = new Page<>();
        page.setCurrent(current).setSize(size);
        IPage<User> resultPage = userService.page(page);
        return Result.success(resultPage);
    }

    /**
     * 范围查询
     */
    @GetMapping("/getByAge")
    public Result getByAge(@RequestParam("leastAge")Integer leastAge,@RequestParam("maxAge")Integer maAge){
        List<User> userByAge = userService.getUserByAge(leastAge, maAge);

        log.info(userByAge.toString());
        List<User> userList = userService.getUserByAges(leastAge, maAge);
        log.info("userList:{}",userList);
        return Result.success(userService.list(new LambdaQueryWrapper<User>()
        .between(User::getAge,leastAge,maAge)));
    }
}
