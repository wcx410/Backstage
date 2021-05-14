package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 采购控制层
 */
@RestController
@CrossOrigin
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private PurchaseOrderService orderService;
    @Autowired
    private PurchaseLinShiService linShiService;

    //查询所有临时采购表的数据
    @RequestMapping("/queryPurchaseLinShiAll")
    public List<PurchaseLinShi> PurchaseLinShiAll() {
        //System.out.println(purchaseService.PurchaseLinShiAll());
//        return purchaseService.PurchaseLinShiAll();
        return linShiService.PurchaseLinShiAll();
    }

    //审核部分-------------
    //查询所有未审核订单信息
    @RequestMapping("/querypurchaseorderAll")
    public List<PurchaseOrder> querypurchaseorderAll() {
        return orderService.querypurchaseorderAll();
    }

    //根据订单id 查询所有采购商品
    @RequestMapping("/querycaigouAll")
    public List<Purchase> querycaigouAll(String orderid) {
        //没网，有待测试确认
        //System.out.println(orderid);
        return purchaseService.querycaigouAll(orderid);
    }

    //提交审核
    @RequestMapping("/shenHe")
    public Message shenHe(PurchaseOrder purchaseOrder) {
        Message message = new Message();
        //修改订单状态  1是采购中
        orderService.updatepurchaseorder(purchaseOrder);
        message.flag = true;
        message.msg = "审核成功√";
        return message;
    }

    //清除所有临时采购表的数据
    @RequestMapping("/cleanPurchaseLinShi")
    public Message cleanPurchaseLinShi() {
        Message message = new Message();
        int row = linShiService.deletePurchaseLinShi();
        if (row > 0) {
            message.flag = true;
            message.msg = "清除成功√";
            return message;
        }else {
            message.flag = false;
            message.msg = "清除失败×";
            return message;
        }
    }
}
