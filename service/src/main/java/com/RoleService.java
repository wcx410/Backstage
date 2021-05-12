package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

public interface RoleService extends IService<Role> {
    public QueryWrapper<Role> queryAllRole(RoleDto roleDto);
}
