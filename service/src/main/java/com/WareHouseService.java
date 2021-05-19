package com;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface WareHouseService extends IService<WareHouse> {
    //根据转出仓库id 修改转出仓库的容量
    int updateWareHouseRon(@Param("chuwarid") String chuwarid,
                           @Param("shopron") Integer shopron);
    //根据转入仓库id 商品id 查询是否有结果
    int queryshop(@Param("commodityid") String commodityid,
                  @Param("ruwarid") String ruwarid);

    //执行添加数量操作  根据商品id和仓库id添加数量
    int addshopnumber(@Param("commodityid") String commodityid,
                      @Param("ruwarid") String ruwarid,
                      @Param("chunumber") String chunumber);

    //根据转出仓库id 修改转入仓库的容量
    int updateWareHouseRon1(@Param("ruwarid") String ruwarid,
                            @Param("shopron") String shopron);

    //给转入仓库添加一条新数据
    int addwarehousestorageshop(@Param("commodityid") String commodityid,
                                @Param("ruwarid") String ruwarid,
                                @Param("chunumber") String chunumber);
}
