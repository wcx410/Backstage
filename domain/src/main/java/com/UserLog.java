package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_log")
public class UserLog {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer user;

    private String content;

    private String data;

    private Date time;


}