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
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {
    @Autowired(required = false)
    private RoleService roleService;
    @Autowired
    private EmpRoleService empRoleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MenuService menuService;

    //查询所有的角色
    @RequestMapping("/queryallrole")
    public IPage<Role> queryAllEmp(@RequestParam(value = "page",defaultValue = "1") int pageno,
                                       @RequestParam(value = "rows",defaultValue = "5")int pagesize,
                                       RoleDto roleDto){
        QueryWrapper<Role> queryWrapper = roleService.queryAllRole(roleDto);
        IPage<Role> iPage = roleService.page(new Page<Role>(pageno,pagesize),queryWrapper);
        return iPage;
    }
    //添加
    public Boolean add(Role role){
        boolean save = roleService.save(role);
        return save;
    }
    //修改
    public Boolean update(Role role){
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<Role>();
        roleQueryWrapper.eq("id",role.getId());
        boolean update = roleService.update(role, roleQueryWrapper);
        return update;
    }
    //删除
    @RequestMapping("/delete")
    public Boolean delete(Integer id){
        Emprole emprole = new Emprole();
        emprole.setEmployee(id);
        QueryWrapper<Emprole> roleQueryWrapper = new QueryWrapper<Emprole>();
        roleQueryWrapper.eq("role",emprole.getRole());
        List<Emprole> list = empRoleService.list(roleQueryWrapper);
        for (int i = 0; i < list.size(); i++) {
            empRoleService.remove(roleQueryWrapper);
        }
        boolean b = roleService.removeById(id);
        return b;
    }
    //根据角色id查询该角色拥有的菜单
    @RequestMapping("/queryMenuByRoleId")
    public List<Menu> queryMenus(Integer id){
        QueryWrapper<Permission> menuQueryWrapper = new QueryWrapper<Permission>();
        menuQueryWrapper.eq("role",id);
        List<Permission> list = permissionService.list(menuQueryWrapper);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            ids.add(list.get(i).getMenu());
        }
        List<Menu> menus = (List<Menu>) menuService.listByIds(ids);
        return menus;
    }
}
