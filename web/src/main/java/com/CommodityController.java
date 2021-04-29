package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
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
    //商品类型service
    @Autowired(required = false)
    private ComTypeService comTypeService;


    //分页条件查询商品数据
    @RequestMapping("/queryallcommodity.action")
    public IPage<Commodity> queryallcommodity(@RequestParam(value = "pageno",defaultValue = "1") int pageno,
                                              @RequestParam(value = "pagesize",defaultValue = "5")int pagesize,
                                              CommodityDto commodityDto){
        if (commodityDto.getState().equals("全部")) {
            commodityDto.setState("");
        }
        if (commodityDto.getState().equals("上架")) {
            commodityDto.setState("1");
        }
        if (commodityDto.getState().equals("未上架")) {
            commodityDto.setState("0");
        }
        if (commodityDto.getState().equals("下架")) {
            commodityDto.setState("2");
        }
        QueryWrapper<Commodity> queryWrapper = commodityService.queryallbydto(commodityDto);
        IPage<Commodity>  iPage= commodityService.page(new Page<Commodity>(pageno,pagesize),queryWrapper);
        System.out.println(iPage);
        return iPage;

    }

    //修改商品状态
    @RequestMapping("/shangjiacommodity.action")
    public String shangjiacommodity(Integer state,Integer id){

        int i = commodityService.updatestate(state, id);
        if(i>0){
            return "修改成功";
        }
        return "修改失败";
    }

    //查询商品类型
    @RequestMapping("/queryAlltype.action")
    @CrossOrigin
    public List<ComType> queryAlltype() {
        return comTypeService.queryAlltype();
    }

    //添加商品
    @RequestMapping("/add.action")
    @CrossOrigin
    public Boolean add(Commodity commodity) {
        boolean res = commodityService.save(commodity);
        return res;
//        System.out.println(commodity);
//        Boolean res=true ;
//        return res;
    }

    @RequestMapping("/queryHome")
    public Map<String,Object> queryHome(){
        Map<String,Object> map = new HashMap<String,Object>();
        //查询首页的--新品上市
        QueryWrapper<Commodity> newReleases = commodityService.queryNewReleases();
        IPage<Commodity> page = commodityService.page(new Page<Commodity>(1, 10), newReleases);
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
