package com;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.OrderDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DistributionService extends IService<Distribution> {
    //查询所有配送订单
    public List<Distribution> querypeisonAll();

    //根据商品id查询拥有这个商品的仓库
    List<WareHouse> warehouseAllByshopid(String shopid);

    //根据仓库id 查询这个仓库里的这个商品的数量
    int querywarehouseshopsum(String warid,String shopid);

    //修改 仓库商品中间表的商品数量数据
    int updateshopsum(@Param("warid") String warid,
                      @Param("shopid") String shopid,
                      @Param("xuqiushopsum") String xuqiushopsum);
    //删除中间表里的这个商品
    int deleteshop(@Param("warid") String warid,
                   @Param("shopid") String shopid);
    //根据订单修改订单状态 为待收货 1
    int updatedingdanstate(@Param("ddid") String ddid);
}
