package com;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmpRoleService empRoleService;

    @RequestMapping("/backLogin")
    public Integer backLogin(Employee emp, HttpServletRequest request){
        QueryWrapper<Employee> empQueryWrapper = new QueryWrapper<Employee>();
        if(!StringUtils.isEmpty(emp.getName())){
            empQueryWrapper.eq("name",emp.getName());
        }
        Employee one = employeeService.getOne(empQueryWrapper);
        if(one!=null){
            request.getSession().setAttribute("employee",one);
            return one.getId();
        }
        return 0;
    }
    //分页条件查询商品数据
    @RequestMapping("/queryallemp")
    public IPage<Employee> queryAllEmp(@RequestParam(value = "page",defaultValue = "1") int pageno,
                                       @RequestParam(value = "rows",defaultValue = "5")int pagesize,
                                       EmployeeDto employeeDto){
        QueryWrapper<Employee> queryWrapper = employeeService.queryAllByEmp(employeeDto);
        IPage<Employee> iPage = employeeService.page(new Page<Employee>(pageno,pagesize),queryWrapper);
        return iPage;
    }
    //添加员工
    @RequestMapping("/add")
    public Boolean add(Employee employee){
        employee.setLastLoginTime(new Date());
        employee.setState(1);
        boolean save = employeeService.save(employee);
        return save;
    }
    //修改员工
    @RequestMapping("/update")
    public Boolean update(Employee employee){
        UpdateWrapper<Employee> employeeUpdateWrapper = new UpdateWrapper<Employee>();
        employeeUpdateWrapper.eq("id",employee.getId());
        boolean update = employeeService.update(employee, employeeUpdateWrapper);
        return update;
    }
    //冻结
    @RequestMapping("/validation")
    public Boolean validation(Integer empId,String password,HttpServletRequest request){
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if(password.equals("123456")){
                Employee emp2 = new Employee();
                emp2.setId(empId);
                emp2.setState(0);
                UpdateWrapper<Employee> employeeUpdateWrapper = new UpdateWrapper<Employee>();
                employeeUpdateWrapper.eq("id",emp2.getId());
                boolean update = employeeService.update(emp2, employeeUpdateWrapper);
                return true;
            }else{
                return false;
            }
    }
    //激活
    @RequestMapping("/unFreeze")
    public Boolean unFreeze(Integer empId,String password,HttpServletRequest request){
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if(password.equals("123456")){
            Employee emp2 = new Employee();
            emp2.setId(empId);
            emp2.setState(1);
            UpdateWrapper<Employee> employeeUpdateWrapper = new UpdateWrapper<Employee>();
            employeeUpdateWrapper.eq("id",emp2.getId());
            boolean update = employeeService.update(emp2, employeeUpdateWrapper);
            return true;
        }else{
            return false;
        }
    }
    //删除
    @RequestMapping("/delete")
    public Boolean delete(Integer empId,String password,HttpServletRequest request) {
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if (password.equals("1234569")) {
            Employee emp2 = new Employee();
            emp2.setId(empId);
            emp2.setState(-1);
            UpdateWrapper<Employee> employeeUpdateWrapper = new UpdateWrapper<Employee>();
            employeeUpdateWrapper.eq("id", emp2.getId());
            boolean update = employeeService.update(emp2, employeeUpdateWrapper);
            //
            Emprole emprole = new Emprole();
            emprole.setEmployee(empId);
            QueryWrapper<Emprole> roleQueryWrapper = new QueryWrapper<Emprole>();
            roleQueryWrapper.eq("employee",emprole.getEmployee());
            List<Emprole> list = empRoleService.list(roleQueryWrapper);
            for (int i = 0; i < list.size(); i++) {
                empRoleService.remove(roleQueryWrapper);
            }
            return true;
        } else {
            return false;
        }
    }
}