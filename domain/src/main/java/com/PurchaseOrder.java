package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("purchaseorder")
public class PurchaseOrder {
    @TableId(value = "orderid",type = IdType.AUTO)
    private Integer orderid;

    private String applicant;

    private String applicantremarks;

    private Integer approvedby;

    private Integer state;

    private String approvedbyremarks;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date operationtime;


}