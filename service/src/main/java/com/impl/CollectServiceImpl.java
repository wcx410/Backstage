package com.impl;


import com.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
    @Autowired
    CollectMapper collectMapper;
    public List<Commodity> queryCollection(Integer uid) {
        return collectMapper.queryCollection(uid);
    }
}
