package com.example.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
        return  Result.success();
    }

    @GetMapping
    public Result<?> findpage(@RequestParam (defaultValue = "1") Integer pageNum,
                              @RequestParam (defaultValue = "10")Integer pageSize,
                              @RequestParam (defaultValue = "") String search){
       LambdaQueryWrapper<Student> wrapper = Wrappers.<Student>lambdaQuery();
       if(StrUtil.isNotBlank(search)){
           wrapper.like(Student::getName, search);
       }
        Page<Student> studentPage=studentmapper.selectPage(new Page<>(pageNum,pageSize),wrapper);
        return Result.success(studentPage);
   }


    @PutMapping
      public Result<?> update(@RequestBody Student student){
        studentmapper.updateById(student);
        return  Result.success();
   }


        @DeleteMapping("/{id}")
    public Result<?> update(@PathVariable Integer id){
        studentmapper.deleteById(id);
        return Result.success();
   }
}
