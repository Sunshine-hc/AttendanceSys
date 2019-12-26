package com.newer.mapper;

import com.newer.domain.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DeptMapper {

    @Select("select * from dept where did = #{deptId}")
    Dept findById(@Param("deptId") Integer deptId);
}
