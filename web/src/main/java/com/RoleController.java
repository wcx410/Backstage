package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {
    @Autowired(required = false)
    private RoleService roleService;

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
}
