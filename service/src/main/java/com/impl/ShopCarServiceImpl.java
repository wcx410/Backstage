package com.impl;

import com.ComOrder;
import com.ShopCarAndCommodity;
import com.ShopCarService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ComOrderMapper;
import com.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ShopCarMapper;
import com.mapper.shop.ShopCarsMapper;
import com.shop.ShopCarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShopCarServiceImpl  extends ServiceImpl<ShopCarMapper, ShopCar> implements ShopCarService {
    @Autowired
    ShopCarMapper shopCarMapper;

    @Autowired
    private ShopCarsMapper shopCarMappers;


    public List<ShopCarAndCommodity> queryShopCarAndCommodityByUId(Integer uid) {
        return shopCarMapper.queryShopCarAndCommodityByUId(uid);
    }

    public PageUtil<MyShop> queryshouhuo(Integer pageNo, Integer pageSize, ShopCarDto dto) {
        PageHelper.startPage(pageNo,pageSize);
        List<MyShop> shouhuo = shopCarMappers.queryshouhuo(dto);
        PageInfo<MyShop> pageInfo = new PageInfo<MyShop>(shouhuo);
        PageUtil<MyShop> pageUtil = new PageUtil<MyShop>();
        pageUtil.setRows(pageInfo.getList());
        pageUtil.setTotal(pageInfo.getTotal());
        return pageUtil;
    }

    public PageUtil<MyShop> querytihuo(Integer pageNo, Integer pageSize, ShopCarDto dto) {
        PageHelper.startPage(pageNo,pageSize);
        List<MyShop> tihuo = shopCarMappers.querytihuo(dto);
        PageInfo<MyShop> pageInfo = new PageInfo<MyShop>(tihuo);
        PageUtil<MyShop> pageUtil = new PageUtil<MyShop>();
        pageUtil.setRows(pageInfo.getList());
        pageUtil.setTotal(pageInfo.getTotal());
        return pageUtil;
    }

    @Override
    public List<MyshopCom> queryTu(Integer uid) {
        return shopCarMapper.queryTu(uid);
    }


}
