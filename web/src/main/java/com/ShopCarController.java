package com;

import com.number.NumberTest;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
//购物车
@RestController
@RequestMapping("/shopCar")
@CrossOrigin
public class ShopCarController {
    @Autowired
    ShopCarService shopCarService;
    @Autowired
    NumberTest numberTest;
    @Autowired(required = false)
    ComOrderService comOrderService;
    @Autowired
    MerchantsService merchantsService;
    @RequestMapping("/shopCarAndCommodities")
    public List<ShopCarAndCommodity>shopCarAndCommodities(Integer uid){
        return shopCarService.queryShopCarAndCommodityByUId(uid);
    }
    @RequestMapping("/addOrder")
    public String addOrder(@RequestBody List<ShopCarAndCommodity> shopCarAndCommodityList){
//        System.out.println(comOrder);
//        System.out.println(shopCarAndCommodityList);
        List<ComOrder> comOrderList = new ArrayList<ComOrder>();
        ComOrder comOrder = null;
        for (int i = 0; i < shopCarAndCommodityList.size(); i++) {
            comOrder = new ComOrder();
            Double zj = shopCarAndCommodityList.get(i).getPrice()*shopCarAndCommodityList.get(i).getNumber();
            comOrder.setMerid(shopCarAndCommodityList.get(i).getMerid());
            comOrder.setTotlemoney(zj.intValue());
            comOrder.setOrderNumber(numberTest.getID("222"));
            comOrder.setSid(shopCarAndCommodityList.get(i).getSid());
            comOrderList.add(comOrder);
        }
        boolean b = comOrderService.saveBatch(comOrderList);

        if (b){
            List<ShopCar> shopCarList = new ArrayList<ShopCar>();
            ShopCar shopCar = null;
            for (int j = 0; j < shopCarAndCommodityList.size(); j++) {
                shopCar = new ShopCar();
                shopCar.setState(1);
                shopCar.setId(shopCarAndCommodityList.get(j).getSid());
                shopCarList.add(shopCar);
            }

            boolean updateShopCar = shopCarService.updateBatchById(shopCarList);
            if (updateShopCar){
                return "添加成功";
            }
        }
            return "添加失败";
//        return shopCarService.save(comOrder)?"添加成功":"添加失败";
    }
    @RequestMapping("/getmers")
    public List<Merchants>getmers(){
        return merchantsService.list();
    }
}
