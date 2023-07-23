package com.xwl.mapper;

import com.xwl.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询整个部门
     * @return
     */
    @Select("select *from tails.dept")
    List<Dept> list();

    /**
     * 根据Id删除
     * @param id
     */
    @Delete("delete from tails.dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into tails.dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Update("update tails.dept set name = #{name} where id = #{id}")
    void update(Dept dept);
}
