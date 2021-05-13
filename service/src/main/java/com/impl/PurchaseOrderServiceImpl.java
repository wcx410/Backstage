package com.impl;

import com.PurchaseOrder;
import com.PurchaseOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.PurchaseOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl extends ServiceImpl<PurchaseOrderMapper, PurchaseOrder> implements PurchaseOrderService {
    @Autowired
    private PurchaseOrderMapper orderMapper;

    @Override
    public List<PurchaseOrder> querypurchaseorderAll() {
        return orderMapper.querypurchaseorderAll();
    }

    @Override
    public int updatepurchaseorder(PurchaseOrder purchaseOrder) {
        return orderMapper.updatepurchaseorder(purchaseOrder);
    }
}
