package com.mapper;


import com.PaiSongYuan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface PaisongyuanMapper extends BaseMapper<PaiSongYuan> {
    @Update("update paisongyuan set state=#{state} where id=#{peisongyuanid}")
    int updatebyid(@Param("state") String state, @Param("peisongyuanid") String peisongyuanid);
}
