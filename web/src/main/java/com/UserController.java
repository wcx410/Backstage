package com;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(User user){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        if(!StringUtils.isEmpty(user.getPhone())){
            userQueryWrapper.eq("phone",user.getPhone());
        }
        User one = userService.getOne(userQueryWrapper);
        if(one!=null){
            return "电话号码已存在";
        }
        boolean save = userService.save(user);
        return save ? "register success":"register fail";
    }
    @RequestMapping("/login")
    public User login(User user, HttpServletRequest request){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        if(!StringUtils.isEmpty(user.getUsername())){
            userQueryWrapper.eq("username",user.getUsername());
        }
        if(!StringUtils.isEmpty(user.getPassword())){
            userQueryWrapper.eq("password",user.getPassword());
        }
        User one = userService.getOne(userQueryWrapper);
        if(one!=null){
            request.getSession().setAttribute("user",one);
            return one;
        }
        return null;
    }
}
