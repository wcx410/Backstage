package com.mapper;

import com.User;
import com.WareHouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface WareHouseMapper  extends BaseMapper<WareHouse> {
    @Update("UPDATE warehouse SET warcapacity=warcapacity+#{shopron}\n" +
            "        WHERE warid=#{chuwarid}")
    //根据转出仓库id 修改转出仓库的容量
    int updateWareHouseRon(@Param("chuwarid") String chuwarid,
                           @Param("shopron") Integer shopron);
}
