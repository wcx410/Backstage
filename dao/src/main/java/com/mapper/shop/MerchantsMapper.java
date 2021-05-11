package com.mapper.shop;

import com.Merchants;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.MerchantsDto;

import java.util.List;

public interface MerchantsMapper extends BaseMapper<Merchants> {
    //查询所有商户信息
    List<Merchants> querymerchants(MerchantsDto dto);

}
