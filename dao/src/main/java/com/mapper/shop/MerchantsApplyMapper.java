package com.mapper.shop;

import com.MerchantsApply;
import com.MyMerchantsApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.MerchantsApplyDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantsApplyMapper extends BaseMapper<MerchantsApply> {
    //查询商户申请为未审核状态的商户
    List<MyMerchantsApply> querymerchantsstatu(MerchantsApplyDto dto);

}
