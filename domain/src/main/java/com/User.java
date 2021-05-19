package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    @TableField(value = "head_portrait")
    private String headPortrait;
    @TableField(value = "phone")
    private String phone;
    @TableField(value = "signature")
    private String signature;
    @TableField(value = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @TableField(value = "uname")
    private String uname;
    @TableField(value = "sex")
    private String sex;
    @TableField(value = "id_card")
    private String idCard;
    @TableField(value = "merid")
    private Integer merid;
    @TableField(value = "last_login_time")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastLoginTime;
    @TableField(value = "is_delete")
    private Integer isDelete;
    @TableField(value = "state")
    private  Integer state;


}