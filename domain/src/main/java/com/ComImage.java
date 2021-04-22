package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("com_image")
public class ComImage {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer commodity;
    private String url;
}
