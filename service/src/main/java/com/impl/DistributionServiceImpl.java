package com.impl;
import com.Distribution;
import com.DistributionService;
import com.WareHouse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.DistributionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionServiceImpl extends ServiceImpl<DistributionMapper, Distribution> implements DistributionService {
    @Autowired
    private DistributionMapper distributionMapper;

    //查询所有配送订单
    public List<Distribution> querypeisonAll() {
       // return distributionMapper.queryall();
        return distributionMapper.queryAll();
    }

    public List<WareHouse> warehouseAllByshopid(String shopid) {
        return distributionMapper.warehouseAllByshopid(shopid);
    }

    public int querywarehouseshopsum(String warid, String shopid) {
        return distributionMapper.querywarehouseshopsum(warid,shopid);
    }


    public int updateshopsum(String warid, String shopid, String xuqiushopsum) {
        return distributionMapper.updateshopsum(warid,shopid,xuqiushopsum);
    }


    public int deleteshop(String warid, String shopid) {
            return distributionMapper.deleteshop(warid,shopid);
    }


    public int updatedingdanstate(String ddid) {
        return distributionMapper.updatedingdanstate(ddid);
    }
}
