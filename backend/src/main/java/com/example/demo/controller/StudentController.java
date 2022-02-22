package com.example.demo.controller;


import com.example.demo.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//表示这是一个返回JSON数据的Controller
@RestController
//接口统一的路由
@RequestMapping("/student")

public class StudentController {

    @PostMapping
    public Result save(){

    }
}
