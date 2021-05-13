package com;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface PaisongjiluService  extends IService<PaiSongJiLu> {
    //根据订单编号修改派送记录表中的状态
    int updatepaisongjilu(Integer did);
}
