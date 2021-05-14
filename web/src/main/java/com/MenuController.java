package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/queryMenu.action")
    public List<Menus> queryMenu(){
        QueryWrapper<Menu> wrapper = new QueryWrapper<Menu>();
        wrapper.eq("layer","1");
        List<Menu> list = menuService.list(wrapper);

        List<Menus> menus = new ArrayList<Menus>();
        for (Menu me:list){
            QueryWrapper<Menu> wrapper1 = new QueryWrapper<Menu>();
            wrapper1.eq("parent",me.getId());
            List<Menu> list1 = menuService.list(wrapper1);
            Menus menus1 = new Menus();
            menus1.setId(me.getId());
            menus1.setIcon(me.getIcon());
            menus1.setLayer(me.getLayer());
            menus1.setName(me.getName());
            menus1.setParent(me.getParent());
            menus1.setType(me.getType());
            menus1.setUrl(me.getUrl());
            menus1.setChildren(list1);
            menus.add(menus1);
        }
        return menus;
    }

    @RequestMapping("/queryallper")
    public List<Menu> queryAllPer(){
        List<Menu> list = menuService.list();
        return list;
    }
}
