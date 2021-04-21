package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("car")
public class Car {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String chepai;
    private Integer state;
}
