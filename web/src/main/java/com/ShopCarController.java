package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//购物车
@RestController
@RequestMapping("/shopCar")
@CrossOrigin
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;
    @RequestMapping("/shopCarAndCommodities")
    public List<ShopCarAndCommodity>shopCarAndCommodities(Integer uid){
        return shopCarService.queryShopCarAndCommodityByUId(uid);
    }
    @RequestMapping("/addOrder")
    public String addOrder(ComOrder comOrder){
        return shopCarService.save(comOrder)?"添加成功":"添加失败";
    }
}
