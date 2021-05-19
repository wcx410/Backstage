package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PurchaseLinShiService extends IService<PurchaseLinShi> {
    int deletePurchaseLinShi();

    List<PurchaseLinShi> PurchaseLinShiAll();

    int updatePurchaseLinShicommoditysum(String commodityid,String caigousum);

    int addLinShiPurchase(String commodityid,String caigousum);
}
