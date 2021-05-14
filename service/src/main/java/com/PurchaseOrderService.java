package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface PurchaseOrderService extends IService<PurchaseOrder> {
    List<PurchaseOrder> querypurchaseorderAll();

    int updatepurchaseorder(PurchaseOrder purchaseOrder);
}
