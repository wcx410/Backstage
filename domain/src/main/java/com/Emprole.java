package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("emprole")
public class Emprole {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer employee;

    private Integer role;


}