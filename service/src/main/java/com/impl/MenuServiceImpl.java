package com.impl;

import com.Menu;
import com.MenuDto;
import com.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public QueryWrapper<Menu> queryAllPer(MenuDto menuDto) {
        QueryWrapper<Menu> queryWrapper =new QueryWrapper<Menu>();
        if(!StringUtils.isEmpty(menuDto.getSearchStr())){
            queryWrapper.like("name",menuDto.getSearchStr());
        }
        return queryWrapper;
    }
}
