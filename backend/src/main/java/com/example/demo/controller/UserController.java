package com.example.demo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserDao;
import com.example.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController

@RequestMapping("/user")


public class UserController {

    @Resource
    UserMapper userMapper;


    //登录逻辑
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
    User res=userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId,user.getId()).eq(User::getPassword,user.getPassword()));
    if(res==null){
        return Result.error("-1","用户名或密码错误");
    }
    return Result.success();
    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        User res=userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId,user.getId()).eq(User::getPassword,user.getPassword()));
        if(res!=null){
            return Result.error("-1","用户已存在");
        }
        userMapper.insert(user);
        return Result.success();

    }
    @Resource
    UserDao userDao;
    @GetMapping("/list")
    public Result<?> list(){
        List<User> user=userDao.queryAll();

        return Result.success(user);
    }

}
