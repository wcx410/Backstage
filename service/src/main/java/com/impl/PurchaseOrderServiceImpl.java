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

    @Override
    public List<PurchaseOrder> purchaseorderAllnowei() {
        return orderMapper.purchaseorderAllnowei();
    }

    @Override
    public int addPurchaseOrder(String applicant, String applicantremarks) {
        return orderMapper.addPurchaseOrder(applicant,applicantremarks);
    }

    @Override
    public int queryorderidBig() {
        return orderMapper.queryorderidBig();
    }

    @Override
    public int rukuUpdateOrderstate(Integer orderid) {
        return orderMapper.rukuUpdateOrderstate(orderid);
    }
}
