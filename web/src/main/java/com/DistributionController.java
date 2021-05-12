package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/peisong")
@RestController
@CrossOrigin
public class DistributionController {
    @Autowired
    private DistributionService distributionService;
    @Autowired
    private CarService carService;
    @Autowired(required = false)
    private PaisongyuanService paisongyuanService;
    @Autowired(required = false)
    private PaisongjiluService paisongjiluService;
    @Autowired(required = false)
    private WareHouseService wareHouseService;

    /**
     * 查询所有订单数据
     */
    @RequestMapping("/peisongAll.action")
    public List<Distribution> peisongAll() {
        return distributionService.querypeisonAll();
    }


    //查询所有拥有这个商品的仓库的数据
    @RequestMapping("/warehouseAllByshopid.action")
    public List<WareHouse> warehouseAllByshopid(String shopid) {
        //根据商品id查询拥有这个商品的仓库
        return distributionService.warehouseAllByshopid(shopid);
    }

    //查询所有车辆
    @RequestMapping("/carAll.action")
    public List<Car> carAll() {
        return carService.queryAll();
    }

     //查询所有配送员
        @RequestMapping("/peisongyuanAll.action")
        public List<PaiSongYuan> peisongyuanAll() {
            return paisongyuanService.queryAll();
        }

    //根据仓库id 查询这个仓库里的这个商品的数量
    @RequestMapping("/querywarehouseshopsum.action")
    public Integer querywarehouseshopsum(String warid, String shopid) {
        return distributionService.querywarehouseshopsum(warid, shopid);
    }

    //点击确认配送
    @RequestMapping("/querenpeisong")
    public Boolean querenpeisong(String warid,
                                 String carid,
                                String peisongyuanid,
                                String shopid,
                                String xuqiushopsum,
                                String guige,
                                String ddid) {
        //拿到仓库id
        //拿到车辆id
        //拿到配送员id
        //拿到商品id
        //拿到配送数量
        //商品规格
        //订单id  ordernumber 编号

        //如果配送数量等于仓库容量 删除 表商品数据
        int cangsum=distributionService.querywarehouseshopsum(warid, shopid);
        if (cangsum==Integer.parseInt(xuqiushopsum)){
            //删除中间表里的这个商品
            distributionService.deleteshop(warid,shopid);
        }
        //修改 仓库商品中间表的商品数量数据
        distributionService.updateshopsum(warid,shopid,xuqiushopsum);
        //计算 这个订单的商品容量
        Float shopron =Float.parseFloat(xuqiushopsum)*Float.parseFloat(guige);
        //修改仓库的容量 转出 增加仓库容量
        wareHouseService.updateWareHouseRon(warid,shopron.intValue());
        //根据订单修改订单状态 为待收货 1
        distributionService.updatedingdanstate(ddid);
        //修改车辆状态
        carService.updatestate("1",carid);
        //修改配送员状态
        paisongyuanService.updatestate("1",peisongyuanid);
        //添加一条配送记录
        PaiSongJiLu paiSongJiLu=new PaiSongJiLu();
        paiSongJiLu.setCarid(Integer.parseInt(carid));
        paiSongJiLu.setDdid(Integer.parseInt(ddid));
        paiSongJiLu.setPid(Integer.parseInt(peisongyuanid));
        paisongjiluService.save(paiSongJiLu);
        return true;
    }


}
