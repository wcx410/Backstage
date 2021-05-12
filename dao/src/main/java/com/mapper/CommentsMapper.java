package com.mapper;

import com.Comments;
import com.CommentsAndCommodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentsMapper extends BaseMapper<Comments> {
    @Select("  SELECT  c.*,m.content AS content FROM  commodity c \n" +
            " INNER JOIN comments AS  m ON c.`id` =m.cid \n" +
            " WHERE m.uid=#{uid} AND m.isdelete = 0 ORDER BY m.comtime")
    public List<CommentsAndCommodity> getComments(@Param("uid") Integer uid);
}
