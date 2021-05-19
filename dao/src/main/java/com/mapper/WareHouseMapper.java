package com.mapper;

import com.User;
import com.WareHouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WareHouseMapper  extends BaseMapper<WareHouse> {
    @Update("UPDATE warehouse SET warcapacity=warcapacity+#{shopron}\n" +
            "        WHERE warid=#{chuwarid}")
    //根据转出仓库id 修改转出仓库的容量
    int updateWareHouseRon(@Param("chuwarid") String chuwarid,
                           @Param("shopron") Integer shopron);

    //根据转入仓库id 商品id 查询是否有结果
    @Select("SELECT count(*) FROM warehousestorage\n" +
            "        WHERE commodityid=#{commodityid} AND warid=#{ruwarid}")
    int queryshop(@Param("commodityid") String commodityid,
                  @Param("ruwarid") String ruwarid);

    //执行添加数量操作  根据商品id和仓库id添加数量
    @Insert("UPDATE warehousestorage SET number=number+#{chunumber}\n" +
            "        WHERE commodityid=#{commodityid} AND warid=#{ruwarid}")
    int addshopnumber(@Param("commodityid") String commodityid,
                      @Param("ruwarid") String ruwarid,
                      @Param("chunumber") String chunumber);

    //根据转出仓库id 修改转入仓库的容量
    @Update("UPDATE warehouse SET warcapacity=warcapacity-#{shopron}\n" +
            "        WHERE warid=#{ruwarid}")
    int updateWareHouseRon1(@Param("ruwarid") String ruwarid,
                            @Param("shopron") String shopron);

    //给转入仓库添加一条新数据
    @Insert("INSERT INTO warehousestorage(commodityid,warid,number) VALUES(#{commodityid},#{ruwarid},#{chunumber})")
    int addwarehousestorageshop(@Param("commodityid") String commodityid,
                                @Param("ruwarid") String ruwarid,
                                @Param("chunumber") String chunumber);
}
