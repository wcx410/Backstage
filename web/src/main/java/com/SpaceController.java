package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//个人中心
@RestController
@RequestMapping("/space")
@CrossOrigin
public class SpaceController {
    @Autowired
    UserService userService;
//    根据id查询用户id
    @RequestMapping("/queryBy")
    public User queryBy(Integer id){
        User byId = userService.getById(id);
        return byId;
    }
//    根据id修改用户，且只修改前端传过来的值
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        boolean b = userService.updateById(user);
        return b?"修改成功":"修改失败";
    }
}
