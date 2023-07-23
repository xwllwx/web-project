package com.xwl.mybatisplus_quickstart;

import com.xwl.dao.UserDao;
import com.xwl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan
class MybatisPlusQuickStartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll(){
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

}
