package com.mapper;

import com.Distribution;
import com.WareHouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DistributionMapper  extends BaseMapper<Distribution> {
//    @Select(" SELECT c.id,c.order_number,c.ordstate,b.id id1,b.name,b.specification,c.totlemoney FROM com_order c\n" +
//            "        INNER JOIN shopcar s ON c.sid=s.id\n" +
//            "        INNER JOIN commodity b ON s.cid=b.id")
    List<Distribution> queryAll();

    //根据商品id查询拥有这个商品的仓库
    @Select(" SELECT war.* FROM warehousestorage stg\n" +
            "        INNER JOIN commodity com ON stg.commodityid=com.id\n" +
            "        INNER JOIN warehouse war ON stg.warid=war.warid\n" +
            "        WHERE com.id=#{shopid}")
    List<WareHouse> warehouseAllByshopid(@Param("shopid") String shopid);

    @Select(" SELECT number FROM warehousestorage WHERE commodityid=#{shopid} AND warid=#{warid}")
    //根据仓库id 查询这个仓库里的这个商品的数量
    int querywarehouseshopsum(@Param("warid") String warid,
                              @Param("shopid") String shopid);

    @Update("UPDATE warehousestorage SET number=number-#{xuqiushopsum}\n" +
            "        WHERE commodityid=#{shopid} AND warid=#{warid}")
    //修改 仓库商品中间表的商品数量数据
    int updateshopsum(@Param("warid") String warid,
                      @Param("shopid") String shopid,
                      @Param("xuqiushopsum") String xuqiushopsum);

    @Delete("delete from warehousestorage\n" +
            "        WHERE commodityid=#{shopid} AND warid=#{warid}")
    //删除中间表里的这个商品
    int deleteshop(@Param("warid") String warid,
                   @Param("shopid") String shopid);

    @Update("  UPDATE com_order SET ordstate=1\n" +
            "        WHERE id=#{ddid}")
    //根据订单修改订单状态 为派送中 1
    int updatedingdanstate(@Param("ddid") String ddid);


}
