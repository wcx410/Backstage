package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ComTypeService extends IService<ComType> {
    //查询所有商品类型
    public List<ComType> queryAlltype();


}
