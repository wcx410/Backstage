package com.mapper;

import com.Distribution;
import com.WareHouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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


}
