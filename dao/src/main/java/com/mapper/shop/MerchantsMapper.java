package com.mapper.shop;

import com.Merchants;
import com.MyShop;
import com.shop.MerchantsDto;
import com.shop.ShopCarDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantsMapper {
    //查询所有商户信息
    List<Merchants> querymerchants(MerchantsDto dto);

    //删除商户(修改商户状态为删除)
    int delmerchants(@Param("id")Integer id);

    //冻结商户(修改商户状态为冻结)
    int dongjiemerchants(@Param("id")Integer id);

    //资料维护
    int updatemerchants(Merchants merchants);

}
