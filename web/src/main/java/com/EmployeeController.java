package com;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    public Employee backLogin(Employee emp, HttpServletRequest request){
        QueryWrapper<Employee> empQueryWrapper = new QueryWrapper<Employee>();
        if(!StringUtils.isEmpty(emp.getName())){
            empQueryWrapper.eq("name",emp.getName());
        }
        Employee one = employeeService.getOne(empQueryWrapper);
        if(one!=null){
            request.getSession().setAttribute("employee",one);
            return one;
        }
        return null;
    }
    //分页条件查询员工数据
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
    public Boolean add(Employee employee, @RequestPart("imgFile") MultipartFile imgFile,HttpServletRequest request){

        if(imgFile!=null) {
            //获取当前项目发布地址/img
            String path = request.getServletContext().getRealPath("/img");

            try {
                imgFile.transferTo(new File(path, imgFile.getOriginalFilename()));
            } catch (IOException e) {

            }
        }
        employee.setImage("img"+imgFile.getOriginalFilename());
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
        if(password.equals(employee.getPassword())){
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
        if(password.equals(employee.getPassword())){
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
        if (password.equals(employee.getPassword())) {
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
    //查询出该用户拥有的角色
    @RequestMapping("/querybyid")
    public List<Emprole> querybyid(Integer id){
        QueryWrapper<Emprole> emproleQueryWrapper = new QueryWrapper<>();
        emproleQueryWrapper.eq("employee",id);
        List<Emprole> list = empRoleService.list(emproleQueryWrapper);
        return list;
    }
    //添加角色
    @RequestMapping("/addRoles")
    public Boolean addRoles(@RequestBody List<Emprole> ids){
        //清空emp这个ID所拥有的角色
        Emprole emprole2 = new Emprole();
        int emp = 0;
        for (int i = 0; i < ids.size(); i++) {
            emp = ids.get(i).getEmployee();
        }
        QueryWrapper<Emprole> emproleQueryWrapper = new QueryWrapper<>();
        emproleQueryWrapper.eq("employee",emp);
        boolean remove = empRoleService.remove(emproleQueryWrapper);
//        if(remove){
            List<Emprole> emproles = new ArrayList<>();

            for (int i = 0; i < ids.size(); i++) {
                Emprole emprole = new Emprole();
                emprole.setEmployee(emp);
                emprole.setRole(ids.get(i).getRole());
                emproles.add(emprole);
            }
            boolean b = empRoleService.saveBatch(emproles);
             return b;
//        }
    }
}
