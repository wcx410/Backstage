package com.mapper;

import com.PurchaseOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
}
