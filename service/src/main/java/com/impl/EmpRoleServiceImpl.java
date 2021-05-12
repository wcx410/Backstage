package com.impl;

import com.EmpRoleService;
import com.Emprole;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.EmpRoleMapper;
import org.springframework.stereotype.Service;

@Service
public class EmpRoleServiceImpl extends ServiceImpl<EmpRoleMapper, Emprole> implements EmpRoleService {
}
