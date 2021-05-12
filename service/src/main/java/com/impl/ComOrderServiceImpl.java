package com.impl;

import com.ComOrder;
import com.ComOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ComOrderMapper;
import org.springframework.stereotype.Service;

@Service
public class ComOrderServiceImpl extends ServiceImpl<ComOrderMapper, ComOrder> implements ComOrderService {
}
