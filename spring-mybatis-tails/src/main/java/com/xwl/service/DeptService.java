package com.xwl.service;

import com.xwl.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部信息
     * @return
     */

    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    void update(Dept dept);
}
