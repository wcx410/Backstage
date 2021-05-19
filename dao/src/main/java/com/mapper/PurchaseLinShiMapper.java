package com.mapper;

import com.PurchaseLinShi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PurchaseLinShiMapper extends BaseMapper<PurchaseLinShi> {
    //清除所有临时采购表的数据
    @Delete("DELETE FROM purchaselinshi")
    int deletePurchaseLinShi();

    //查询所有临时采购表的数据
    @Select("SELECT com.id, com.name, com.price, com.specification, linshi.caigousum\n" +
            "        FROM commodity com\n" +
            "        INNER JOIN purchaselinshi linshi\n" +
            "        ON linshi.id = com.id")
    List<PurchaseLinShi> PurchaseLinShiAll();

    @Update("UPDATE purchaselinshi SET caigousum=caigousum+#{caigousum}\n" +
            "        WHERE id=#{commodityid}")
    int updatePurchaseLinShicommoditysum(@Param("commodityid") String commodityid,@Param("caigousum") String caigousum);


    //根据商品id 和 采购数量 向临时采购表添加数据
    @Insert("INSERT INTO purchaselinshi(id,caigousum)\n" +
            "        VALUES ( #{commodityid}, #{caigousum})")
    int addLinShiPurchase(@Param("commodityid") String commodityid,
                          @Param("caigousum") String caigousum);
}
