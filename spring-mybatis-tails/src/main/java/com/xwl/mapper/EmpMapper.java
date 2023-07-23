package com.xwl.mapper;

import com.xwl.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 查询总记录数
     *
     * @return
     */
    @Select("select COUNT(*) from tails.emp")
    public long count();

    /**
     * 查询分页列表需要的
     *
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from tails.emp order by create_time desc limit #{start},#{pageSize} ;")
    public List<Emp> page(Integer start, Integer pageSize);


    @Select("select * from tails.emp;")
    public List<Emp> list();


    void delete(List<Integer> ids);


    @Insert("insert into tails.emp(username,name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    @Select("select * from tails.emp where id = #{id}")
    Emp getEmpByID(Integer id);


    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);

    /**
     * 根据用户名和密码查询员工是否存在
     * @param emp
     * @return
     */
    @Select("select * from tails.emp where username = #{username} and password = #{password}")
    Emp getByUserNameAndUserPassWord(Emp emp);
}
