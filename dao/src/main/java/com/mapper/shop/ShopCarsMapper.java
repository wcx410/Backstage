package com.mapper.shop;

import com.MyShop;
import com.shop.ShopCarDto;

import java.util.List;

public interface ShopCarsMapper {
    //商户查询订单状态为正在派送的订单信息
    List<MyShop> queryshouhuo(ShopCarDto dto);

    //商户查询订单状态为待提货的订单信息
    List<MyShop> querytihuo(ShopCarDto dto);

}
