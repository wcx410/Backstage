package com.mapper;

import com.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CommodityMapper extends BaseMapper<Commodity> {
    @Update("update commodity set state=#{state} where id = #{id}")
    int update(@Param("state") Integer state,@Param("id") Integer id);
}
