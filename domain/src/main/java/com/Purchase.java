package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Purchase")
public class Purchase {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer orderid;

    private Integer commodityid;

    private String commodityname;

    private Float price;

    private Integer commoditysum;


}