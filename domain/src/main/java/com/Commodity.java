package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("commodity")
public class Commodity {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String particulars;
    private String image;
    private Double price;
    private String unit;
    private String specification;
    private String manufacturer;
    private Integer comType;
    private Date putawayDate;
    private Date newestPutawayDate;
    private Integer state;
}
