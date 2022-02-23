package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("student")
//自动生成Javabean的get/set方法
@Data
public class Student {
    @TableId(type= IdType.AUTO)//ID自增
    private int id;
    private String name;
    private String sex;
    private int age;
    private String phone;
}
