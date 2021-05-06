package com.impl;

import com.ShopCarAndCommodity;
import com.ShopCarService;
import com.mapper.ShopCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopCarServiceImpl implements ShopCarService {
    @Autowired
    ShopCarMapper shopCarMapper;
    public List<ShopCarAndCommodity> queryShopCarAndCommodityByUId(Integer uid) {
        return shopCarMapper.queryShopCarAndCommodityByUId(uid);
    }
}
