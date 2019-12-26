package com.newer.mapper;

import com.newer.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.Properties;

public interface UserMapper {

    //通过id查询用户数据

    @Results(value = {

    })
    @Select("select * from user where id = #{uid}")
    User findById(@Param("uid") Integer uid);

    //根据账号，密码查询用户信息
    @Results(value = {
            @Result(property = "uid", column = "uid", id = true),
            @Result(property = "uname", column = "uname"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "unum", column = "unum"),
            @Result(property = "utype", column = "utype"),
            @Result(property = "job", column = "job"),
            @Result(property = "ustate", column = "ustate"),
            @Result(property = "dept", column = "did",javaType = com.newer.domain.Dept.class,
            one = @One(select = "com.newer.mapper.DeptMapper.findById")),
    })
    @Select("SELECT * FROM USER  LEFT JOIN dept  ON dept_id = did WHERE username = #{username} AND PASSWORD  = #{password}")
    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);


}
