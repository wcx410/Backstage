package com.impl;

import com.Merchants;
import com.MyOrder;
import com.OrderService;
import com.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.shop.OrderMapper;
import com.shop.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public PageUtil<MyOrder> querycomorder(Integer pageNo, Integer pageSize, OrderDto dto) {
        PageHelper.startPage(pageNo,pageSize);
        List<MyOrder> myOrders = orderMapper.querycomorder(dto);
        PageInfo<MyOrder> pageInfo = new PageInfo<MyOrder>(myOrders);
        PageUtil<MyOrder> pageUtil = new PageUtil<MyOrder>();
        pageUtil.setRows(pageInfo.getList());
        pageUtil.setTotal(pageInfo.getTotal());
        return pageUtil;
    }
}
