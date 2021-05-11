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


}
