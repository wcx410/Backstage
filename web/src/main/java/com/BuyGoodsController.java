package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//已购买的宝贝
@RestController
@CrossOrigin
@RequestMapping("/buy")
public class BuyGoodsController {
    @Autowired
    BuyGoodsService buyGoodsService;
    @RequestMapping("/getBuyGoods")
    public List<Commodity> getBuyGoods(Integer uid,@RequestParam(defaultValue = "3") Integer state){
        List<Commodity> buyGoods = buyGoodsService.getBuyGoods(uid, state);
        return buyGoods;
    }
}
