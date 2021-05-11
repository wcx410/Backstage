package com.impl;

import com.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.ComOrderMapper;
import com.mapper.shop.MerchantsMapper;
import com.shop.MerchantsDto;
import com.shop.ShopCarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantsServiceImpl extends ServiceImpl<MerchantsMapper, Merchants> implements MerchantsService {
    @Autowired
    private MerchantsMapper merchantsMapper;

    public PageUtil<Merchants> querymerchants(Integer pageNo, Integer pageSize, MerchantsDto dto) {
        PageHelper.startPage(pageNo,pageSize);
        List<Merchants> merchants = merchantsMapper.querymerchants(dto);
        PageInfo<Merchants> pageInfo = new PageInfo<Merchants>(merchants);
        PageUtil<Merchants> pageUtil = new PageUtil<Merchants>();
        pageUtil.setRows(pageInfo.getList());
        pageUtil.setTotal(pageInfo.getTotal());
        return pageUtil;
    }


}
