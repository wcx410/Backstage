package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/commodity")
public class CommodityController {

    //商品service
    @Autowired(required = false)
    private  CommodityService commodityService;


    //分页条件查询商品数据
    @RequestMapping("/queryallcommodity.action")
    @ResponseBody //异步
//    @CrossOrigin  //前后端分离
    public IPage<Commodity> queryallcommodity(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                              @RequestParam(value = "pagesize",defaultValue = "5")int pagesize,
                                              CommodityDto commodityDto){
        QueryWrapper<Commodity> queryWrapper = commodityService.queryallbydto(commodityDto);
        IPage<Commodity>  iPage= commodityService.page(new Page<Commodity>(pageno,pagesize),queryWrapper);
        return iPage;

    }

    //修改商品状态
    @RequestMapping("/shangjiacommodity.action")
//    @CrossOrigin
    public String shangjiacommodity(Integer state,Integer id){

        int i = commodityService.updatestate(state, id);
        if(i>0){
            return "修改成功";
        }
        return "修改失败";
    }

    @RequestMapping("/queryHome")
    public Map<String,Object> queryHome(){
        Map<String,Object> map = new HashMap<>();
        //查询首页的--新品上市
        QueryWrapper<Commodity> newReleases = commodityService.queryNewReleases();
        IPage<Commodity> page = commodityService.page(new Page<>(1, 10), newReleases);
        map.put("newReleases",page.getRecords());
        //查询首页的--热销商品
        List<Commodity> queryHotSale = commodityService.queryHotSale();
        map.put("hotSale",queryHotSale);
        //查询首页的--猜你喜欢
        List<Commodity> queryGuessLikes = commodityService.queryGuessLikes();
        map.put("guessLikes",queryGuessLikes);
        return map;
    }
    }
