package com.impl;

import com.PickupMerchants;
import com.PickupMerchantsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.shop.PickupMerchantsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickupMerchantsServiceImpl extends ServiceImpl<PickupMerchantsMapper,PickupMerchants> implements PickupMerchantsService {

}
