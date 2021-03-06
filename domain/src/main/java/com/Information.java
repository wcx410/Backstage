package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("information")
public class Information {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String content;

    private Date sendtime;

    private Integer uid;

    private Integer userid;

    private Integer infstate;

    private Integer isRead;


}