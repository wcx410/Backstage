package com;

import com.shop.MerchantsApplyDto;
import com.shop.MerchantsDto;
import com.shop.OrderDto;
import com.shop.ShopCarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/shop")
@RestController
@CrossOrigin
public class ShopController {
    @Autowired
    private ShopCarService shopCarService;

    @Autowired
    private MerchantsService merchantsService;

    @Autowired
    private MerchantsApplyService merchantsApplyService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PickupMerchantsService pickupMerchantsService;

    //商户查询订单状态为正在派送的订单信息
    @RequestMapping("/queryshouhuo.action")
    public PageUtil<MyShop> queryshouhuo(ShopCarDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyShop> pageUtil = this.shopCarService.queryshouhuo(pageNo, pageSize, dto);
        return pageUtil;
    }

    //商户查询订单状态为待提货的订单信息
    @RequestMapping("/querytihuo.action")
    public PageUtil<MyShop> querytihuo(ShopCarDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyShop> pageUtil = this.shopCarService.querytihuo(pageNo, pageSize, dto);
        return pageUtil;
    }

    //查询所有商户信息
    @RequestMapping("/querymerchants.action")
    public PageUtil<Merchants> querymerchants(MerchantsDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<Merchants> pageUtil = this.merchantsService.querymerchants(pageNo, pageSize, dto);
        return pageUtil;
    }

    //查询商户申请为未审核状态的商户
    @RequestMapping("/querymerchantsstatu.action")
    public PageUtil<MyMerchantsApply> querymerchantsstatu(MerchantsApplyDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyMerchantsApply> pageUtil = this.merchantsApplyService.querymerchantsstatu(pageNo, pageSize, dto);
        return pageUtil;
    }

    //商户申请修改状态0：未审核1：审核通过2：审核不通过
    @RequestMapping("/updatemerchantsstatu.action")
    public String updatemerchantsstatu(Integer userid,Integer state){
        int row = this.merchantsApplyService.updatemerchantsstatu(userid, state);
        String result="";
        if(state==1){
            result="注册成功!";
        }else {
            result="注册失败!";
        }
        return result;
    }

    //删除商户(修改商户状态为删除)
    @RequestMapping("/delmerchants.action")
    public int delmerchants(Integer id){
        int row = this.merchantsService.delmerchants(2);
        return row;
    }

    //冻结商户(修改商户状态为冻结)
    @RequestMapping("/dongjiemerchants.action")
    public int dongjiemerchants(Integer id){
        int row = this.merchantsService.dongjiemerchants(id);
        return row;
    }

    //查询订单信息
    @RequestMapping("/querycomorder.action")
    public PageUtil<MyOrder> querycomorder(OrderDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyOrder> pageUtil = null;
        if(dto!=null ){
            if(dto.getSearch_ordstate().equals("-1")){
                dto.setSearch_ordstate("");
            }
            pageUtil = this.orderService.querycomorder(pageNo, pageSize, dto);
        }
        return pageUtil;
    }

    //资料维护
    @RequestMapping("/updatemerchants.action")
    public int updatemerchants(Merchants merchants){
        int row = this.merchantsService.updatemerchants(merchants);
        return row;
    }

    //收货，向收货门店表里面添加数据
    @RequestMapping("/insertpickupmerchants.action")
    public int insertpickupmerchants(PickupMerchants pickupMerchants){
        pickupMerchants.setUser(1);
        pickupMerchants.setMerchant(1);
        pickupMerchants.setRemark("香蕉");
        pickupMerchants.setCreateTime(new Date());
        int row = this.pickupMerchantsService.insertpickupmerchants(pickupMerchants);
        return row;
    }
}
