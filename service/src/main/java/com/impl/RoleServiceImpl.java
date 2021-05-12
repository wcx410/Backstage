package com.impl;

import com.Role;
import com.RoleDto;
import com.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    public QueryWrapper<Role> queryAllRole(RoleDto roleDto) {

        QueryWrapper<Role> queryWrapper =new QueryWrapper<Role>();
        if(!StringUtils.isEmpty(roleDto.getSearchStr())){
            queryWrapper.like("name",roleDto.getSearchStr());
        }
        return queryWrapper;
    }
}
