package com;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.OrderDto;

import java.util.List;

public interface DistributionService extends IService<Distribution> {
    //查询所有配送订单
    public List<Distribution> querypeisonAll();

    //根据商品id查询拥有这个商品的仓库
    List<WareHouse> warehouseAllByshopid(String shopid);

    //根据仓库id 查询这个仓库里的这个商品的数量
    int querywarehouseshopsum(String warid,String shopid);
}
