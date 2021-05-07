package com.impl;

import com.Merchants;
import com.MerchantsService;
import com.MyShop;
import com.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.shop.MerchantsMapper;
import com.shop.MerchantsDto;
import com.shop.ShopCarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantsServiceImpl implements MerchantsService {
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

    public int delmerchants(Integer id) {
        return this.merchantsMapper.delmerchants(id);
    }

    public int dongjiemerchants(Integer id) {
        return this.merchantsMapper.dongjiemerchants(id);
    }

    public int updatemerchants(Merchants merchants) {
        return this.updatemerchants(merchants);
    }

}
