package com.impl;

import com.Purchase;
import com.PurchaseLinShi;
import com.PurchaseLinShiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.PurchaseLinShiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseLinShiServiceImpl extends ServiceImpl<PurchaseLinShiMapper, PurchaseLinShi> implements PurchaseLinShiService {
    @Autowired
    private PurchaseLinShiMapper linShiMapper;

    @Override
    public int deletePurchaseLinShi() {
        return linShiMapper.deletePurchaseLinShi();
    }

    @Override
    public List<PurchaseLinShi> PurchaseLinShiAll() {
        return linShiMapper.PurchaseLinShiAll();
    }

    @Override
    public int updatePurchaseLinShicommoditysum(String commodityid, String caigousum) {
        return linShiMapper.updatePurchaseLinShicommoditysum(commodityid,caigousum);
    }

    @Override
    public int addLinShiPurchase(String commodityid, String caigousum) {
        return linShiMapper.addLinShiPurchase(commodityid,caigousum);
    }
}
