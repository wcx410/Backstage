package com.mapper;

import com.PaiSongJiLu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface PaisongjiluMapper  extends BaseMapper<PaiSongJiLu> {
    //根据订单编号修改派送记录表中的状态
    int updatepaisongjilu(@Param("pid")Integer did);
}
