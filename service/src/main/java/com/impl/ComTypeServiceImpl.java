package com.impl;

import com.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ComTypeMapper;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;


@Service
public class ComTypeServiceImpl extends ServiceImpl<ComTypeMapper, ComType> implements ComTypeService {


   //查询所有商品类型
    public List<ComType> queryAlltype() {
        QueryWrapper<ComType> queryWrapper=new QueryWrapper<ComType>();
        List<ComType> comTypes =this.list(queryWrapper);
        return comTypes;
    }

    //条件查询所有商品类型
    public QueryWrapper<ComType> queryallbydto(String name) {
        QueryWrapper<ComType> queryWrapper =new QueryWrapper<ComType>();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        return queryWrapper;
    }



}
