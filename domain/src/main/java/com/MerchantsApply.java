package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("merchants_apply")
public class MerchantsApply {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String name;

    private String address;

    private Date applyTime;

    private String userMessage;

    private Integer state;

    private String systemMessage;

    private Integer isRead;


}