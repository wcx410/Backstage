package com.mapper;

import com.ShopCar;
import com.ShopCarAndCommodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopCarMapper extends BaseMapper<ShopCar> {
//
    @Select(" SELECT c.*,s.`number`as number  FROM commodity c INNER JOIN shopcar s ON c.`id`=s.`cid` WHERE s.`uid`=#{uid} and s.state=1")
    @Results(id="CommodityMap", value={
            @Result(column="id", property="id", id=true),
            @Result(column="number", property="number"),
            @Result(column="name", property="name"),
            @Result(column="particulars", property="particulars"),
            @Result(column="image", property="image"),
            @Result(column="price", property="price"),
            @Result(column="unit", property="unit"),
            @Result(column="specification", property="specification"),
            @Result(column="manufacturer", property="manufacturer"),
            @Result(column="com_type", property="comType"),
            @Result(column="putaway_date", property="putawayDate"),
            @Result(column="newest_putaway_date", property="newestPutawayDate"),
            @Result(column="state", property="state"),
    })
    public List<ShopCarAndCommodity> queryShopCarAndCommodityByUId(@Param("uid") Integer uid);
}
