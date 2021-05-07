package com.impl;

import com.PickupMerchants;
import com.PickupMerchantsService;
import com.mapper.shop.PickupMerchantsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickupMerchantsServiceImpl implements PickupMerchantsService {
    @Autowired
    private PickupMerchantsMapper pickupMerchantsMapper;

    public int insertpickupmerchants(PickupMerchants pickupMerchants) {
        return this.pickupMerchantsMapper.insertpickupmerchants(pickupMerchants);
    }
}
