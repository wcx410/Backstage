package com;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("menu")
public class Menus extends Menu {

    @TableField(exist = false)
    List<Menu> children;
    @TableField(exist = false)
    boolean checked = false;
}
