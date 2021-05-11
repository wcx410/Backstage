package com.impl;

import com.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.shop.MerchantsApplyMapper;
import com.shop.MerchantsApplyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MerchantsApplyServiceImpl extends ServiceImpl<MerchantsApplyMapper, MerchantsApply> implements MerchantsApplyService  {
    @Autowired
    private MerchantsApplyMapper merchantsApplyMapper;


    public PageUtil<MyMerchantsApply> querymerchantsstatu(Integer pageNo, Integer pageSize, MerchantsApplyDto dto) {
        PageHelper.startPage(pageNo,pageSize);
        List<MyMerchantsApply> myMerchantsApplies = merchantsApplyMapper.querymerchantsstatu(dto);
        PageInfo<MyMerchantsApply> pageInfo = new PageInfo<MyMerchantsApply>(myMerchantsApplies);
        PageUtil<MyMerchantsApply> pageUtil = new PageUtil<MyMerchantsApply>();
        pageUtil.setRows(pageInfo.getList());
        pageUtil.setTotal(pageInfo.getTotal());
        return pageUtil;
    }

    public int updatemerchantsstatu(int id, int state) {
        return merchantsApplyMapper.updatemerchantsstatu(id,state);
    }
}
