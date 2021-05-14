package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface WareHouseStorageService extends IService<WareHouseStorage> {
    //根据仓库id查询所有仓库存储商品
    List<WareHouseStorage> queryWareHouseStorageAll(String id);
}
