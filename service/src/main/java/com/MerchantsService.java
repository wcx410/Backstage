package com;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.MerchantsDto;


public interface MerchantsService extends IService<Merchants> {
    //查询所有商户信息
    PageUtil<Merchants> querymerchants(Integer pageNo, Integer pageSize, MerchantsDto dto);

}
