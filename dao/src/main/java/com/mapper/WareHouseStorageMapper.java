package com.mapper;

import com.WareHouse;
import com.WareHouseStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WareHouseStorageMapper extends BaseMapper<WareHouseStorage> {

    //根据仓库id查询所有仓库存储商品
    @Select("SELECT house.warid as warid,house.warname as warname, com.id as commodityid, com.name as name, warest.number as number,com.specification as specification FROM warehousestorage warest\n" +
            "        INNER JOIN warehouse house\n" +
            "         ON warest.warid = house.warid\n" +
            "        INNER JOIN commodity com\n" +
            "         ON warest.commodityid = com.id\n" +
            "        WHERE house.warid = #{id}")
    List<WareHouseStorage> queryWareHouseStorageAll(String id);
}
