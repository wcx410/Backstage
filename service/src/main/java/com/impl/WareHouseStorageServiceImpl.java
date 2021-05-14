package com.impl;

import com.WareHouseStorage;
import com.WareHouseStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.WareHouseStorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseStorageServiceImpl extends ServiceImpl<WareHouseStorageMapper, WareHouseStorage> implements WareHouseStorageService{
    @Autowired
    private WareHouseStorageMapper storageMapper;

    @Override
    public List<WareHouseStorage> queryWareHouseStorageAll(String id) {
        return storageMapper.queryWareHouseStorageAll(id);
    }
}
