package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CommodityService extends IService<Commodity> {
    //条件查询所有商品
    public QueryWrapper<Commodity> queryallbydto(CommodityDto commodityDto);

    //修改商品状态
    public int updatestate(Integer state ,Integer id);
}
