package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
//我的足迹
@RestController
@RequestMapping("/foot")
@CrossOrigin
public class MyFootprintController {
    @Autowired
    LookHistoryService lookHistoryService;
//    根据用户id查询该用户的历史足迹
    @RequestMapping("/queryFoot")
    public List<Commodity> queryFoot(Integer uid){
        return  lookHistoryService.queryFoot(uid);
    }
//    向足迹表里插入一条数据
    @RequestMapping("/addHistory")
    public String addHistory(LookHistory lookHistory){
        lookHistory.setTime(new Date());
        boolean save = lookHistoryService.save(lookHistory);
        return save?"添加成功":"添加失败";
    }
}
