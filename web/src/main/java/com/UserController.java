package com;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
    //组装查询和分页
    @RequestMapping("/queryUser.action")
    public IPage<User> queryUser(@RequestParam(value = "page",defaultValue = "1")int pageno,
                                 @RequestParam(value = "rows",defaultValue = "5")int pagesize,
                                 UserDto userDto){
//        System.out.println(userDto);userDto
//        System.out.println("------------");
             QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
         if (!StringUtils.isEmpty(userDto.getUsername())){
             queryWrapper.like("username",userDto.getUsername());//where realnamelike '%val%'
         } else if (!userDto.getState().equals(-1)){
             if (userDto.getState()==2){
                 queryWrapper.eq("state",userDto.getState());//.or().eq("state","")
             }else if (userDto.getState()==1){
                 queryWrapper.eq("state",userDto.getState());
             }
//             userService.selectByState(userDto.getState());
//             queryWrapper.like("id_card",userDto.getIdCard());
         }
            if (!userDto.getSex().equals("-1")){
                queryWrapper.eq("sex",userDto.getSex());
            }
             if (!userDto.getIsDelete().equals(-1)){
                 queryWrapper.eq("is_delete",userDto.getIsDelete());
             }

         //根据ID进行排序
       // queryWrapper.orderByAsc("id");
//         queryWrapper.orderByDesc("id");


         IPage<User> iPage = userService.page(new Page<User>(pageno, pagesize),queryWrapper);
//        System.out.println("-----------");
//        System.out.println("-----------");
//        System.out.println("-----------");
        return iPage;

    }
    @RequestMapping("queryByid.action")
    public User queryByid(int id){
        User byId = userService.getById(id);
        System.out.println(byId);
        return byId;

    }

    @RequestMapping(value = "update.action",produces ="application/json;charset=UTF-8")
//
    public  String update(User users, @RequestPart("imgFile") MultipartFile imgFile, HttpServletRequest request){
        String path = "";
        if(imgFile!=null){
            //获取当前项目发布地址/img
            path =  request.getServletContext().getRealPath("/img");
            try {
                imgFile.transferTo(new File(path,imgFile.getOriginalFilename()));
                    users.setHeadPortrait("img/"+imgFile.getOriginalFilename());
            }catch (IOException e){

            }

        };
        int i = userService.updateuser(users);
        return "修改成功";
    }

    @RequestMapping("Deluser.action")
    public String Deluser(Integer id){
        int deluser = userService.Deluser(id);
        return "删除成功";
    }
    @RequestMapping("Delzero.action")
    public String Delzero(Integer id){
        int delzero = userService.Delzero(id);
        return "恢复成功";
    }
}
