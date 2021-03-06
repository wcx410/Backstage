package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

public interface MenuService extends IService<Menu> {
    public QueryWrapper<Menu> queryAllPer(MenuDto menuDto);
}
