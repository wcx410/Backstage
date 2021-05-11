package com;

import com.shop.MerchantsDto;
import com.shop.OrderDto;

import java.util.List;

public interface OrderService {
    //查询订单信息
    PageUtil<MyOrder> querycomorder(Integer pageNo, Integer pageSize, OrderDto dto);
}
