package com;


import com.baomidou.mybatisplus.extension.service.IService;

import com.shop.ShopCarDto;

import java.util.List;

public interface ShopCarService extends IService<ShopCar> {
    public List<ShopCarAndCommodity> queryShopCarAndCommodityByUId(Integer uid);

    //商户查询订单状态为正在派送的订单信息
    PageUtil<MyShop> queryshouhuo(Integer pageNo, Integer pageSize, ShopCarDto dto);

    //商户查询订单状态为待提货的订单信息
    PageUtil<MyShop> querytihuo(Integer pageNo, Integer pageSize, ShopCarDto dto);

    //销量
    public List<MyshopCom> queryTu(Integer uid);
}
