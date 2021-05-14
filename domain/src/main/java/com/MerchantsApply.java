package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date applyTime;

    private String userMessage;

    private Integer state;

    private String systemMessage;

    private Integer isRead;

    private String photos;

    private String idcardimagezheng;

    private String idcardimagefan;


}