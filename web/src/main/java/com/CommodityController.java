package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CommodityController {

    //商品service
    @Autowired(required = false)
    private  CommodityService commodityService;


    //分页条件查询商品数据
    @RequestMapping("/queryallcommodity.action")
    @ResponseBody //异步
    @CrossOrigin  //前后端分离
    public IPage<Commodity> queryallcommodity(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                              @RequestParam(value = "pagesize",defaultValue = "5")int pagesize,
                                              CommodityDto commodityDto){
        QueryWrapper<Commodity> queryWrapper = commodityService.queryallbydto(commodityDto);
        IPage<Commodity>  iPage= commodityService.page(new Page<Commodity>(pageno,pagesize),queryWrapper);
        return iPage;

    }

    //修改商品状态
    @RequestMapping("/shangjiacommodity.action")
    @CrossOrigin
    public String shangjiacommodity(Integer state,Integer id){

        int i = commodityService.updatestate(state, id);
        if(i>0){
            return "修改成功";
        }
        return "修改失败";
    }

    }
