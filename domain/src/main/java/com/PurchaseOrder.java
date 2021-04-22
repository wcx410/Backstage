package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("purchaseorder")
public class PurchaseOrder {
    @TableId(value = "orderid",type = IdType.AUTO)
    private Integer orderid;

    private Integer applicant;

    private String applicantremarks;

    private Integer approvedby;

    private Integer state;

    private String approvedbyremarks;

    private Date operationtime;


}