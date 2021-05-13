package com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("PurchaseLinShi")
public class PurchaseLinShi {
    //商品id;
    Integer id;
    //商品名
    String name;
    //商品价格
    Float price;
    //商品规格
    String  specification;
    //采购数量
    Integer caigousum;
}
