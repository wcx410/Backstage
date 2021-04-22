package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("pickup_merchants")
public class PickupMerchants {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer user;

    private Integer merchant;

    private String remark;

    private Date createTime;


}