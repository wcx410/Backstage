package com.impl;

import com.Car;
import com.ComType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.CarMapper;
import com.CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {
    @Autowired(required = false)
    private CarMapper carMapper;
    //查询所有车辆
    public List<Car> queryAll() {
        QueryWrapper<Car> queryWrapper=new QueryWrapper<Car>();
        List<Car> cars =this.list(queryWrapper);
        return cars;
    }

    @Override
    public int updatestate(String state, String carid) {
        return carMapper.updatebyid(state,carid);
    }

}
