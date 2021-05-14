package com.mapper;

import com.Purchase;
import com.PurchaseOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PurchaseMapper extends BaseMapper<Purchase> {



    @Select("SELECT com.id as commodityid,com.name as commodityname,com.price as price,com.specification,pur.commoditysum FROM commodity com\n" +
            "        INNER JOIN purchase pur\n" +
            "        ON com.id=pur.commodityid\n" +
            "        WHERE pur.orderid=#{orderid}")
    List<Purchase> querycaigouAll(@Param("orderid") String orderid);
}
