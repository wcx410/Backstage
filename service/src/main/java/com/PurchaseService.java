package com;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseService extends IService<Purchase> {



    List<Purchase> querycaigouAll(@Param("orderid") String orderid);
}
