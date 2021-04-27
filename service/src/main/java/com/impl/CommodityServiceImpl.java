package com.impl;

import com.ComType;
import com.Commodity;
import com.CommodityDto;
import com.CommodityService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




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
        if(!StringUtils.isEmpty(commodityDto.getState())){
            queryWrapper.like("state",Integer.valueOf(commodityDto.getState()));
        }
        return queryWrapper;
    }

    //修改商品状态
    public int updatestate(Integer state,Integer id) {
        return commodityMapper.update(state,id);
    }

    @Override
    public QueryWrapper<Commodity> queryNewReleases() {
        //查询首页的--新品上市
        QueryWrapper<Commodity> queryWrapper =new QueryWrapper<Commodity>();
        queryWrapper.eq("state",1);
        queryWrapper.orderByDesc("newest_putaway_date");

        return queryWrapper;
    }

    @Override
    public List<Commodity> queryHotSale() {
        return commodityMapper.queryHotSale();
    }

    @Override
    public List<Commodity> queryGuessLikes() {
        return commodityMapper.queryGuessLikes();
    }



}
