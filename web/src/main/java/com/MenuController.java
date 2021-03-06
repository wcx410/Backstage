package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MenusService menusService;

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
    //

    @RequestMapping("/querymenuthir")
    public List<Menus> queryMenuThir(){
        QueryWrapper<Menu> wrapper = new QueryWrapper<Menu>();
        wrapper.eq("layer","2");
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
            menus1.setChecked(menus1.isChecked());
            menus.add(menus1);
        }
        return menus;
    }

    @RequestMapping("/queryallper")
    public List<Menu> queryAllPer(){
        List<Menu> list = menuService.list();
        return list;
    }
    @RequestMapping("/querybyid")
    public List<Integer> queryById(String id){
        //????????????
        List<Menus> menus = menusService.list();
        //?????????????????????
        QueryWrapper<Permission> permissionQueryWrapper = new QueryWrapper<Permission>();
        permissionQueryWrapper.eq("role",id);
        List<Permission> listper = permissionService.list(permissionQueryWrapper);
        List<Menus> menuList = new ArrayList<Menus>();
        for (int i = 0; i < listper.size(); i++) {
            int j = listper.get(i).getMenu();
            menuList.add(menusService.getById(j));
        }
        Menus menus1 = new Menus();
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < menuList.size(); i++) {
            menuList.get(i).setChecked(true);
            integers.add(menuList.get(i).getId());
        }
        return integers;
    }
    //??????
    @RequestMapping("/authorization")
    public boolean authorization(@RequestBody List<Permission> idss){
        int role = 0;
        for (int i = 0; i < idss.size(); i++) {
            role = idss.get(i).getRole();
        }
        QueryWrapper<Permission> permissionQueryWrapper = new QueryWrapper<Permission>();
        permissionQueryWrapper.eq("role",role);
        permissionService.remove(permissionQueryWrapper);
        //
        List<Permission> permissions = new ArrayList<Permission>();
        for (int i = 0; i < idss.size(); i++) {
            Permission permission = new Permission();
            permission.setMenu(idss.get(i).getMenu());
            permission.setRole(role);
            permissions.add(permission);
        }
        boolean b = permissionService.saveBatch(permissions);
        return b;
    }
}
