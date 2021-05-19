package com.mapper;

import com.PurchaseOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PurchaseOrderMapper extends BaseMapper<PurchaseOrder> {
    @Select("SELECT pur.orderid,em.name as applicant,pur.applicantremarks,pur.approvedby,pur.state,pur.approvedbyremarks,pur.operationtime FROM purchaseorder pur\n" +
            "        INNER JOIN employee em\n" +
            "        ON pur.applicant =em.id\n" +
            "        WHERE pur.state=0")
    List<PurchaseOrder> querypurchaseorderAll();

    @Update("UPDATE purchaseorder SET approvedby=#{approvedby},state=#{state},approvedbyremarks=#{approvedbyremarks},operationtime=DEFAULT\n" +
            "        WHERE orderid=#{orderid}")
    int updatepurchaseorder(PurchaseOrder purchaseOrder);

    @Select("SELECT pur.orderid,em.name applicant,pur.applicantremarks,em2.id approvedby,pur.state,pur.approvedbyremarks,pur.operationtime FROM purchaseorder pur\n" +
            "        INNER JOIN employee em\n" +
            "        ON pur.applicant =em.id\n" +
            "        INNER JOIN employee em2\n" +
            "        ON pur.approvedby =em2.id\n" +
            "        where pur.state!=0")
    List<PurchaseOrder> purchaseorderAllnowei();

    @Insert("INSERT INTO purchaseorder VALUES(NULL,#{applicant},#{applicantremarks},NULL,0,NULL,DEFAULT)")
    int addPurchaseOrder(@Param("applicant") String applicant,@Param("applicantremarks") String applicantremarks);

    //查询订单详情表的最大订单号
    @Select("SELECT orderid FROM purchaseorder\n" +
            "        ORDER BY orderid\n" +
            "        DESC\n" +
            "        LIMIT 1")
    int queryorderidBig();

    //入库完成 修改订单状态为 3 已入库
    @Update("UPDATE purchaseorder SET state=3,operationtime=DEFAULT\n" +
            "        WHERE orderid=#{orderid}")
    int rukuUpdateOrderstate(@Param("orderid") int orderid);
}
