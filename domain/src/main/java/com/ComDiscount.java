package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("com_discount")
public class ComDiscount {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer commodity;
    private Date startTime;
    private Date endTime;
    private Double discount;
    private String remark;
}
