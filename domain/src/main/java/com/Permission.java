package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("permission")
public class Permission {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer menu;

    private Integer role;


}