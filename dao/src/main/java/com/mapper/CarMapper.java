package com.mapper;

import com.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CarMapper extends BaseMapper<Car> {
    @Update("update car set state=#{state} where id=#{carid}")
    int updatebyid(@Param("state")String state,@Param("carid")String carid);
}
