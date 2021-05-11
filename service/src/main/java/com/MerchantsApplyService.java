package com;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.MerchantsApplyDto;


public interface MerchantsApplyService  extends IService<MerchantsApply> {
    //查询商户申请为未审核状态的商户
    PageUtil<MyMerchantsApply> querymerchantsstatu(Integer pageNo, Integer pageSize, MerchantsApplyDto dto);

    //商户申请修改状态0：未审核1：审核通过2：审核不通过
    int updatemerchantsstatu(int userid,int state);
}
