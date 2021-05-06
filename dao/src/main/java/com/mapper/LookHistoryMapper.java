package com.mapper;

import com.*;
import com.LookHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LookHistoryMapper extends BaseMapper<LookHistory> {
    @Select("SELECT  c.* FROM USER u INNER JOIN look_history lh\n" +
            " ON u.`id`=lh.`user` INNER JOIN commodity c ON lh.`cid`=c.`id` \n" +
            " WHERE lh.`user` =#{uid} ORDER BY lh.`time`DESC")
    public List<Commodity> queryFoot(@Param("uid") Integer uid);
}
