package com.example.demo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;

//表示这是一个返回JSON数据的Controller
@RestController
//接口统一的路由
@RequestMapping("/student")

public class StudentController {

    @Resource
    StudentMapper studentmapper;

    @PostMapping

    //@RequestBody 把前台传过来的JSON对象映射成Java实体
    public Result<?> save(@RequestBody Student student){

        studentmapper.insert(student);
        return new Result();
    }

   @GetMapping
    public Result<?> findpage(@RequestParam (defaultValue = "1") Integer pageNum,@RequestParam (defaultValue = "10")Integer pageSize,@RequestParam (defaultValue = "''") String search){
        Page<Student> studentPage=studentmapper.selectPage(new Page<>(pageNum,pageSize), Wrappers.<Student>lambdaQuery().like(Student::getName,search));

        return Result.success(studentPage);
   }
}
