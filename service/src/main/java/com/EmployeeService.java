package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

public interface EmployeeService extends IService<Employee> {
    //条件查询所有的商品
    public QueryWrapper<Employee> queryAllByEmp(EmployeeDto employeeDto);
}
