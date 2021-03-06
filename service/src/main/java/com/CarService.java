package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CarService extends IService<Car> {
    //查询所有车辆
    public List<Car> queryAll();

    //修改车辆状态
    int updatestate(String state,String carid);

}
