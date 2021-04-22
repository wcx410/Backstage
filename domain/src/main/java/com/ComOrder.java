package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("com_order")
public class ComOrder {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer ordstate;
    private String orderNumber;
    private Integer isdelete;
    private Integer sid;
}
