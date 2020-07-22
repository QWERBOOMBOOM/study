package com.cyc.mydemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 增加用户
     * @param user
     * @return Result
     * @throws MyException
     */
    @PostMapping("/add")
    public Result add(@RequestBody @Valid UserVO user) throws MyException {

        if ( userService.count(new LambdaQueryWrapper<User>().eq(User::getName,user.getName()))>0){
            throw new MyException(0001,"已经存在用户");
        }
        User addUser = new User();
        addUser.setName(user.getName())
                .setPassword(user.getPassword())
                .setSalt(user.getSalt())
                .setAge(user.getAge())
                .setCreateTime(LocalDateTime.now());
        if (!userService.save(addUser)){
            throw new MyException(0002,"添加用户失败");
        }
        return Result.success("添加成功");
    }

    /**
     * 根据用户名称查询
     * @param name
     * @return Result
     */
    @GetMapping("/{name}")
    public Result getUser(@PathVariable String name){

        return Result.success(userService.getOne(new LambdaQueryWrapper<User>()
        .like(User::getName,name)));
    }

    /**
     * 修改用户
     * @param vo
     * @return Result
     */
    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody @Valid UserVO vo){
        if (userService.count(new LambdaQueryWrapper<User>()
        .eq(User::getName,vo.getName()).ne(User::getId,vo.getId()))>0){
            return Result.fail("已经存在重名的数据");
        }
        User user = new User()
                .setName(vo.getName())
                .setSalt(vo.getSalt())
                .setPassword(vo.getPassword())
                .setAge(vo.getAge())
                .setUpdateTime(LocalDateTime.now());
        LambdaUpdateWrapper<User> lw = new LambdaUpdateWrapper<User>();
        lw.eq(User::getId,vo.getId());

        return Result.success(userService.update(user,lw)?"修改成功":"修改失败");
    }

    /**
     * 分页查询
     * @param size
     * @return Result
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
