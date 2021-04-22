package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("collect")
public class Collect {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Date coltime;
    private Integer cid;
}
