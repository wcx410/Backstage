package com.impl;

import com.ComLabel;
import com.ComLableService;
import com.ComType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ComLableMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ComLableServiceImpl extends ServiceImpl<ComLableMapper,ComLabel> implements ComLableService {
    //查询所有商品标签
    public List<ComLabel> queryAlllable() {
        QueryWrapper<ComLabel> queryWrapper=new QueryWrapper<ComLabel>();
        List<ComLabel> comLabels =this.list(queryWrapper);
        return comLabels;
    }

    //条件查询所有商品标签
    public QueryWrapper<ComLabel> queryallbydto(String name) {
        QueryWrapper<ComLabel> queryWrapper =new QueryWrapper<ComLabel>();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        return queryWrapper;
    }
}
