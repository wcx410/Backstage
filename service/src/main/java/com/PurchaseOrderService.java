package com;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseOrderService extends IService<PurchaseOrder> {
    List<PurchaseOrder> querypurchaseorderAll();

    int updatepurchaseorder(PurchaseOrder purchaseOrder);

    List<PurchaseOrder> purchaseorderAllnowei();

    //生成订单详情表 未审核记录
    int addPurchaseOrder(@Param("applicant") String applicant,
                         @Param("applicantremarks") String applicantremarks);

    int queryorderidBig();

    int rukuUpdateOrderstate(Integer orderid);
}
