package com.impl;

import com.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.BuyGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyGoodsServiceImpl extends ServiceImpl<BuyGoodsMapper, Commodity> implements BuyGoodsService {
    @Autowired
    BuyGoodsMapper buyGoodsMapper;
    public List<Commodity> getBuyGoods(Integer uid,Integer state) {
        return buyGoodsMapper.getBuyGoods(uid,state);
    }
}
