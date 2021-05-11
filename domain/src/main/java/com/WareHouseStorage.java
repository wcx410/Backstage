package com;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("warehousestorage")
//仓库存储商品实体
public class WareHouseStorage {
   private String warid;
   private String warname;
   private Integer commodityid;
   private String name;
   private Integer number;
   private String specification;


}
