package com.xwl;

import com.xwl.mapper.UserMapper;
import com.xwl.poro.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser(){
        List<User> list = userMapper.list();
        list.stream().forEach(user -> {
            System.out.println(user);
        });
    }

}
