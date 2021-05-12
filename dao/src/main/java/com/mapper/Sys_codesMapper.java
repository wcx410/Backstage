package com.mapper;


import java.util.List;

import com.Sys_codes;
import com.Sys_codesExample;
import org.apache.ibatis.annotations.Param;

public interface Sys_codesMapper {
    int countByExample(Sys_codesExample example);

    int deleteByExample(Sys_codesExample example);

    int deleteByPrimaryKey(Integer ID);

    int insert(Sys_codes record);

    int insertSelective(Sys_codes record);

    List<Sys_codes> selectByExample(Sys_codesExample example);

    Sys_codes selectByPrimaryKey(Integer ID);

    int updateByExampleSelective(@Param("record") Sys_codes record, @Param("example") Sys_codesExample example);

    int updateByExample(@Param("record") Sys_codes record, @Param("example") Sys_codesExample example);

    int updateByPrimaryKeySelective(Sys_codes record);

    int updateByPrimaryKey(Sys_codes record);
}