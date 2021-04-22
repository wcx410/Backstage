package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Pickup")
public class Pickup {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String address;

    private String phone;

    private Date ptime;

    private Integer pstate;

    private Integer uid;


}