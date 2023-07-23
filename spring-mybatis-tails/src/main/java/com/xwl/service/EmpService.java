package com.xwl.service;

import com.xwl.pojo.Emp;
import com.xwl.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 实现分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page,
                  Integer pageSize,
                  String name,
                  Short gender,
                  LocalDate begin,
                  LocalDate end);

    /**
     * 批量删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据id获取员工信息
     * @param id
     * @return
     */
    Emp getEmpByID(Integer id);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);

    /**
     * 员工登陆
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
