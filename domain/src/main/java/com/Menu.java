package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("menu")
public class Menu {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String icon;

    private String url;

    private Integer layer;

    private String type;

    private Integer parent;


}