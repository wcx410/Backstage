package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("star")
public class Star {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    private Integer cid;

    private Float count;


}