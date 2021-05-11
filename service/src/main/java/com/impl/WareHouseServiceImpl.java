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
}
