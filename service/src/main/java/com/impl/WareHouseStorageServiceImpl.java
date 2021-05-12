package com.impl;

import com.WareHouseStorage;
import com.WareHouseStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.WareHouseStorageMapper;
import org.springframework.stereotype.Service;

@Service
public class WareHouseStorageServiceImpl extends ServiceImpl<WareHouseStorageMapper, WareHouseStorage> implements WareHouseStorageService {
}
