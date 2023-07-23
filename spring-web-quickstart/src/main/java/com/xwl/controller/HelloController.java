package com.xwl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//请求处理类
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "name") String username, Integer age){
        System.out.println("hello,world");
        System.out.println(username+" "+age);
        return username+age;
    }


}
