package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String headPortrait;

    private String phone;

    private String signature;

    private Date birthday;

    private String uname;

    private String sex;

    private String idCard;

    private Integer merid;

    private Date lastLoginTime;

    private Integer isDelete;


}