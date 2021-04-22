package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Merchants")
public class Merchants {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String address;

    private String phone;

    private Float longitude;

    private Float latitude;

    private Date openTimeFrom;

    private Date openTimeTo;

    private String remark;

    private Integer state;


}