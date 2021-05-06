package com.mapper;

import com.Collect;
import com.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectMapper extends BaseMapper<Collect> {

//根据用户id查询用户收藏的商品
    @Select(" SELECT c.* FROM commodity c INNER JOIN collect l \n" +
            " ON c.`id`=l.`cid` INNER JOIN USER u \n" +
            " ON l.`uid`=u.`id` WHERE l.`uid`=#{uid}")
    public List<Commodity> queryCollection(@Param("uid") Integer uid);
}
