package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("paisongjilu")
public class PaiSongJiLu {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    private Integer ddid;

    private Integer carid;

    private Integer state;


}