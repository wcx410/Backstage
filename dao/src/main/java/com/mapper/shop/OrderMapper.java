package com.mapper.shop;

import com.MyOrder;
import com.shop.MerchantsDto;
import com.shop.OrderDto;

import java.util.List;

public interface OrderMapper {
    //查询订单信息
    List<MyOrder> querycomorder(OrderDto dto);

}
