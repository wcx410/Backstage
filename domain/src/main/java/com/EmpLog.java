package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("emp_log")
public class EmpLog {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer emp;

    private String content;

    private String data;

    private Date time;


}