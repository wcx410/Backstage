package com;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuyGoodsService extends IService<Commodity> {
    public List<Commodity> getBuyGoods(Integer uid,Integer state);
}
