package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("shopcar")
public class ShopCar {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer number;

    private Date jointime;

    private Float totalprice;

    private Integer cid;

    private Integer uid;

    private Integer state;
}