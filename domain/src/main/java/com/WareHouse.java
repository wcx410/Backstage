package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("WareHouse")
public class WareHouse {
    @TableId(value = "warid",type = IdType.AUTO)
    private Integer warid;

    private String warname;

    private String wartype;

    private Integer warcapacity;

    private String waraddress;

    private Float longitude;

    private Float latitude;

    private Integer warstate;


}