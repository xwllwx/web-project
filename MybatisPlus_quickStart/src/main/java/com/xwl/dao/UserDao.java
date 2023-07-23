package com.xwl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xwl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao extends BaseMapper<User> {
}
