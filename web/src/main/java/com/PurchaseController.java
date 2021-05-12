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

    //查询所有临时采购表的数据
    @RequestMapping("/queryPurchaseLinShiAll")
    public List<Purchase> PurchaseLinShiAll() {
        //System.out.println(purchaseService.PurchaseLinShiAll());
//        return purchaseService.PurchaseLinShiAll();
        return null;
    }
}
