package com.mapper;

import com.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommodityMapper extends BaseMapper<Commodity> {
    @Update("update commodity set state=#{state} where id = #{id}")
    int update(@Param("state") Integer state,@Param("id") Integer id);

    @Select("select commodity.* from commodity\n" +
            "        left join shopcar s on commodity.id = s.cid\n" +
            "        left join com_order co on s.id = co.sid\n" +
            "        where commodity.state = 1\n" +
            "        group by commodity.id\n" +
            "        order by sum(s.number) desc\n" +
            "        limit 10")
    List<Commodity> queryHotSale();

    @Select("select * from commodity\n" +
            "        where state = 1\n" +
            "        order by rand()\n" +
            "        limit 10")
    List<Commodity> queryGuessLikes();
}
