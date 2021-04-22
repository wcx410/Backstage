package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("search_record")
public class SearchRecord {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer user;

    private String content;

    private Date time;


}