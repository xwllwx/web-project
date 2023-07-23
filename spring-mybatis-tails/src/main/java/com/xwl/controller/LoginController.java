package com.xwl.controller;

import com.xwl.pojo.Emp;
import com.xwl.pojo.Result;
import com.xwl.service.EmpService;
import com.xwl.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("登陆检查：{}",emp);
        Emp e = empService.login(emp);
        //登陆成功，生成令牌，下发令牌
        if(e!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);//jwt令牌包含了当前登陆的员工信息
            return Result.success(jwt);
        }
//        return e != null ? Result.success(e):Result.error("登陆失败，用户名或者密码错误");
        return Result.error("登陆失败，用户名或者密码错误");
    }
}
