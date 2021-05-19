package com.impl;

import com.Employee;
import com.EmployeeDto;
import com.EmployeeService;
import org.springframework.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    public QueryWrapper<Employee> queryAllByEmp(EmployeeDto employeeDto) {

        System.out.println(employeeDto);
        QueryWrapper<Employee> queryWrapper =new QueryWrapper<Employee>();
        if(!StringUtils.isEmpty(employeeDto.getSearchStr())){
            queryWrapper.like("name",employeeDto.getSearchStr());
        }
        if(!StringUtils.isEmpty(employeeDto.getSearchSex())){
            queryWrapper.eq("sex",employeeDto.getSearchSex());
        }
        if(!StringUtils.isEmpty(employeeDto.getSearchSate())){
            queryWrapper.eq("state",employeeDto.getSearchSate());
        }else{
            queryWrapper.ne("state",-1);
        }
        return queryWrapper;
    }
}
