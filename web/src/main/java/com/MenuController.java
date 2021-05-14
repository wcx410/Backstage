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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @RequestMapping("/querymenus")
    public Set<MyMenu> convertMenu(Set<MyMenu> menus,Integer parentId){
        Set<MyMenu> myMenus = new HashSet<MyMenu>();
        for (MyMenu sysMenus:menus){
            if(sysMenus.getParent() == parentId){
                MyMenu menus1 = new MyMenu();
                menus1.setId(sysMenus.getId());
                menus1.setParent(sysMenus.getParent());
                menus1.setName(sysMenus.getName());
                menus1.setIcon(sysMenus.getIcon());
                menus1.setIcon(sysMenus.getUrl());
                menus1.setLayer(sysMenus.getLayer());
                menus1.setType(sysMenus.getType());
                menus1.setChecked(sysMenus.isChecked());
                //
                Set<MyMenu> myMenus1 = convertMenu(menus,sysMenus.getId());
                menus1.setChildren(myMenus1);
                myMenus.add(menus1);
            }
        }
        if(myMenus.size()==0){
            return null;
        }
        return myMenus;
    }
}
