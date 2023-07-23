package com.xwl.controller;

import com.xwl.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(User user) {
        System.out.println(user);
        return "hello";
    }

    @RequestMapping("/date")
    public String getDate(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime localDateTime) {
        System.out.println(localDateTime);
        return "ok";
    }

    @RequestMapping("/josnParam")
    public User getUser(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping("/josnId/{id}/{name}")
    public String getId(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "ok";
    }
}
