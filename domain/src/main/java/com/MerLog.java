package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("mer_log")
public class MerLog {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer emp;

    private String content;

    private String data;

    private Date time;


}