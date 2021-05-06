package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
//我的收藏
@RestController
@RequestMapping("/collect")
@CrossOrigin
public class CollectController {
    @Autowired
    CollectService collectService;
//    添加一条收藏记录
    @RequestMapping("/addCollect")
    public String addCollect(Collect collect){
        collect.setColtime(new Date());
        boolean save = collectService.save(collect);
        return save?"添加成功":"添加失败";
    }
//根据用户id查询用户收藏的商品
    @RequestMapping("/getCollection")
    public List<Commodity> getCollection(Integer uid) {
        return collectService.queryCollection(uid);
    }
}
