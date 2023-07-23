package com.xwl.service.impl;

import com.xwl.mapper.EmpMapper;
import com.xwl.pojo.Emp;
import com.xwl.pojo.PageBean;
import com.xwl.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        Long count = empMapper.count();
        Integer start = (page - 1) * pageSize;
        List<Emp> page1 = empMapper.page(start, pageSize);
        PageBean pageBean = new PageBean(count, page1);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

    }

    @Override
    public Emp getEmpByID(Integer id) {
        return empMapper.getEmpByID(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUserNameAndUserPassWord(emp);
    }
}
