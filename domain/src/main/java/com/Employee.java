package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("employee")
public class Employee {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

    private String image;

    private String sex;

    private String phone;

    private String icCard;

    private String address;

    private String email;

    private String remark;

    private Date lastLoginTime;

    private Integer state;


}