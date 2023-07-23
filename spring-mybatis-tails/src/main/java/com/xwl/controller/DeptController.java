package com.xwl.controller;

import com.xwl.anno.Log;
import com.xwl.pojo.Dept;
import com.xwl.pojo.Result;
import com.xwl.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;


    @GetMapping
    public Result list(){
        log.info("查询全部数据信息");
        List<Dept> depyList = deptService.list();
        return Result.success(depyList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        /**
         *
         */
        log.info("根据Id删除部门：{}",id);
        deptService.delete(id);
        return Result.success();
    }


    /**
     * 新增部门
     * @return
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 修改部门
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门信息#{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
