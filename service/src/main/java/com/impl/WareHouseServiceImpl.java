package com.impl;

import com.WareHouse;
import com.WareHouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.WareHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WareHouseServiceImpl  extends ServiceImpl<WareHouseMapper, WareHouse> implements WareHouseService {
     @Autowired
     private WareHouseMapper wareHouseMapper;

    public int updateWareHouseRon(String chuwarid, Integer shopron) {
        return wareHouseMapper.updateWareHouseRon(chuwarid,shopron);
    }

    @Override
    public int queryshop(String commodityid, String ruwarid) {
        return wareHouseMapper.queryshop(commodityid,ruwarid);
    }

    @Override
    public int addshopnumber(String commodityid, String ruwarid, String chunumber) {
        return wareHouseMapper.addshopnumber(commodityid, ruwarid, chunumber);
    }

    @Override
    public int updateWareHouseRon1(String ruwarid, String shopron) {
        return wareHouseMapper.updateWareHouseRon1(ruwarid, shopron);
    }

    @Override
    public int addwarehousestorageshop(String commodityid, String ruwarid, String chunumber) {
        return wareHouseMapper.addwarehousestorageshop(commodityid, ruwarid, chunumber);
    }

}
