package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("look_history")
public class LookHistory {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer user;

    private Integer cid;

    private Date time;


}