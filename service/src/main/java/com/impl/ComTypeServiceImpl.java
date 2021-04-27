package com.impl;

import com.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ComTypeMapper;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ComTypeServiceImpl extends ServiceImpl<ComTypeMapper, ComType> implements ComTypeService {
   //查询所有商品类型
    public List<ComType> queryAlltype() {
        QueryWrapper<ComType> queryWrapper=new QueryWrapper<ComType>();
        List<ComType> comTypes =this.list(queryWrapper);
        return comTypes;
    }
}
