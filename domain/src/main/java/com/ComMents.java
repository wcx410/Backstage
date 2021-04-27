package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("comments")
public class ComMents {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String content;
    private Date comtime;
    private Integer cid;
    private Integer uid;
    private Integer isdelete;
}
