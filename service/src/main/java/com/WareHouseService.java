package com;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface WareHouseService extends IService<WareHouse> {
    //根据转出仓库id 修改转出仓库的容量
    int updateWareHouseRon(@Param("chuwarid") String chuwarid,
                           @Param("shopron") Integer shopron);
}
