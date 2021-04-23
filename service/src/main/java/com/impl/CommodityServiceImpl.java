package com.impl;

import com.Commodity;
import com.CommodityDto;
import com.CommodityService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements  CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;

    //条件查询所有商品
    public QueryWrapper<Commodity> queryallbydto(CommodityDto commodityDto) {
        QueryWrapper<Commodity> queryWrapper =new QueryWrapper<Commodity>();
        if(!StringUtils.isEmpty(commodityDto.getName())){
            queryWrapper.like("name",commodityDto.getName());
        }
        if(!StringUtils.isEmpty(commodityDto.getCom_type())){
            queryWrapper.like("com_type",commodityDto.getCom_type());
        }
        return queryWrapper;
    }

    //修改商品状态
    public int updatestate(Integer state,Integer id) {
        return commodityMapper.update(state,id);
    }
}
