package com.mapper;

import com.PurchaseLinShi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
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
            "        ON linshi.commodityid = com.id")
    List<PurchaseLinShi> PurchaseLinShiAll();
}
