package com;

import com.number.NumberTest;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(value = "/addShopCar",produces = "application/json;charset=UTF-8")
    public String addShopCar(ShopCar shopCar){
        shopCar.setJointime(new Date());
        boolean save = shopCarService.save(shopCar);
        return save?"加入成功":"加入失败";
    }
    @RequestMapping("/shopCarAndCommodities")
    public List<ShopCarAndCommodity>shopCarAndCommodities(Integer uid){
        return shopCarService.queryShopCarAndCommodityByUId(uid);
    }
    @RequestMapping("/addOrder")
    public boolean addOrder(@RequestBody List<ShopCarAndCommodity> shopCarAndCommodityList){
//        System.out.println(comOrder);
//        System.out.println(shopCarAndCommodityList);
        List<ComOrder> comOrderList = new ArrayList<ComOrder>();
        ComOrder comOrder = null;
        String strid = numberTest.getID("200");
        for (int i = 0; i < shopCarAndCommodityList.size(); i++) {
            comOrder = new ComOrder();
            Double zj = shopCarAndCommodityList.get(i).getPrice()*shopCarAndCommodityList.get(i).getNumber();
            comOrder.setMerid(shopCarAndCommodityList.get(i).getMerid());
            comOrder.setTotlemoney(zj.intValue());
            comOrder.setOrderNumber(strid);
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
            if (!updateShopCar){
                return false;
            }
        }
            return true;
//        return shopCarService.save(comOrder)?"添加成功":"添加失败";
    }
    @RequestMapping("/getmers")
    public List<Merchants>getmers(){
        return merchantsService.list();
    }
}
