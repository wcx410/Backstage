package com;

import com.shop.MerchantsDto;
import org.apache.ibatis.annotations.Param;


public interface MerchantsService {
    //查询所有商户信息
    PageUtil<Merchants> querymerchants(Integer pageNo, Integer pageSize, MerchantsDto dto);

    //删除商户(修改商户状态为删除)
    int delmerchants(Integer id);

    //冻结商户(修改商户状态为冻结)
    int dongjiemerchants(Integer id);

    //资料维护
    int updatemerchants(Merchants merchants);
}
