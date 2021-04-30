package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ComLableService extends IService<ComLabel> {
    //查询所有商品标签
    public List<ComLabel> queryAlllable();

    //条件查询所有商品标签
    public QueryWrapper<ComLabel> queryallbydto(String name);

}
