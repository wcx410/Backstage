package com.impl;

import com.Car;
import com.mapper.CarMapper;
import com.CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {

}
