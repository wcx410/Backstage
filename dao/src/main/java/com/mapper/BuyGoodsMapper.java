package com.mapper;

import com.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BuyGoodsMapper extends BaseMapper<Commodity> {
//    根据用户id和已收货的状态查询用户购买的商品
    @Select(" SELECT c.* FROM commodity c INNER JOIN shopcar s ON c.`id`=s.cid \n" +
            " INNER JOIN com_order o ON s.id= o.sid \n" +
            " WHERE o.ordstate =#{state} AND o.isdelete=0 AND s.uid=#{uid}")
    public List<Commodity> getBuyGoods(@Param("uid") Integer uid,@Param("state") Integer state);
}
