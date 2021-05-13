package com.impl;

import com.Purchase;
import com.PurchaseOrder;
import com.PurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;



    @Override
    public List<Purchase> querycaigouAll(String orderid) {
        return purchaseMapper.querycaigouAll(orderid);
    }
}
