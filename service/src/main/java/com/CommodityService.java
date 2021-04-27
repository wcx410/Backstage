package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface CommodityService extends IService<Commodity> {
    //条件查询所有商品
    public QueryWrapper<Commodity> queryallbydto(CommodityDto commodityDto);

    //修改商品状态
    public int updatestate(Integer state ,Integer id);

    //查询首页的--新品上市
    QueryWrapper<Commodity> queryNewReleases();
    //查询首页的--热销商品
    List<Commodity> queryHotSale();
    //查询首页的--猜你喜欢
    List<Commodity> queryGuessLikes();
}
